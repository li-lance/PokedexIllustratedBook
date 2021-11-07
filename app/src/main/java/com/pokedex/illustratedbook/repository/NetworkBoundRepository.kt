package com.pokedex.illustratedbook.repository

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import com.pokedex.illustratedbook.model.ErrorResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.Response

abstract class NetworkBoundRepository<RESULT, REQUEST> {
  fun asFlow() = flow {

    // Emit Database content first
    emit(Resource.Success(fetchFromLocal().first()))

    // Fetch latest data from remote
    val apiResponse = fetchFromRemote()

    // Parse body
    val remoteData = apiResponse.body()

    // Check for response validation
    if (apiResponse.isSuccessful && remoteData != null) {
      // Save data into the persistence storage
      saveRemoteData(remoteData)
    } else {
      // Something went wrong! Emit Error state.
      emit(Resource.Failed(ErrorResponse(apiResponse.code(), apiResponse.message())))
    }

    // Retrieve data from persistence storage and emit
    emitAll(
      fetchFromLocal().map {
        Resource.Success<RESULT>(it)
      }
    )
  }.catch { e ->
    e.printStackTrace()
    emit(Resource.Failed(ErrorResponse(400, "Network error! Can't get latest data.")))
  }

  /**
   * Saves retrieved from remote into the persistence storage.
   */
  @WorkerThread
  protected abstract suspend fun saveRemoteData(response: REQUEST)

  /**
   * Retrieves all data from persistence storage.
   */
  @MainThread
  protected abstract fun fetchFromLocal(): Flow<RESULT>

  /**
   * Fetches [Response] from the remote end point.
   */
  @MainThread
  protected abstract suspend fun fetchFromRemote(): Response<REQUEST>
}