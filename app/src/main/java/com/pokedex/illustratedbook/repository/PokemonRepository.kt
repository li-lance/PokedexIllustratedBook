package com.pokedex.illustratedbook.repository

import android.content.Context
import com.pokedex.illustratedbook.api.ApiService
import com.pokedex.illustratedbook.data.PokemonEntity
import com.pokedex.illustratedbook.data.getPokemonList
import com.pokedex.illustratedbook.data.savePokemonList
import com.pokedex.illustratedbook.data.toPokemonEntity
import com.pokedex.illustratedbook.model.NamedApiResourceList
import com.pokedex.illustratedbook.model.Pokemon
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

interface IPokemonRepository {
  fun pokemonList(offset: Int, limit: Int): Flow<Resource<List<PokemonEntity>>>
//  fun pokemon(): Flow<Resource<Pokemon>>
}

class PokemonRepository @Inject constructor(val api: ApiService, @ApplicationContext val context: Context) : IPokemonRepository {
  override fun pokemonList(offset: Int, limit: Int): Flow<Resource<List<PokemonEntity>>> {
    return object : NetworkBoundRepository<List<PokemonEntity>, NamedApiResourceList>() {
      override suspend fun saveRemoteData(response: NamedApiResourceList) {
        val list = mutableListOf<PokemonEntity>()
        response.results.forEach {
          list.add(it.toPokemonEntity())
        }
        savePokemonList(context,list)
      }

      override fun fetchFromLocal(): Flow<List<PokemonEntity>> = getPokemonList(context)

      override suspend fun fetchFromRemote(): Response<NamedApiResourceList> =
        api.getPokedexList(offset, limit)

    }.asFlow()
  }

//  override fun pokemon(): Flow<Resource<Pokemon>> {
//
//  }

}