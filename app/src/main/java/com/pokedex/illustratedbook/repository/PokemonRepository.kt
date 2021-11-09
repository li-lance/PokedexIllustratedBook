package com.pokedex.illustratedbook.repository

import com.pokedex.illustratedbook.api.ApiService
import com.pokedex.illustratedbook.data.PokemonCache
import com.pokedex.illustratedbook.data.PokemonEntity
import com.pokedex.illustratedbook.model.NamedApiResourceList
import com.pokedex.illustratedbook.model.Pokemon
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

interface IPokemonRepository {
  fun pokemon(id: Int): Flow<Resource<PokemonEntity>>

  suspend fun pokemonList(offset: Int, limit: Int): Response<NamedApiResourceList>
}

class PokemonRepository @Inject constructor(
  val api: ApiService,
  val cache:PokemonCache
) : IPokemonRepository {
  override fun pokemon(id: Int): Flow<Resource<PokemonEntity>> {
    return object : NetworkBoundRepository<PokemonEntity, Pokemon>() {
      override suspend fun saveRemoteData(response: Pokemon) = cache.savePokemon(response)

      override fun fetchFromLocal(): Flow<PokemonEntity> = cache.getPokemon()

      override suspend fun fetchFromRemote(): Response<Pokemon> = api.getPokemon(id)
    }.asFlow()
  }

  override suspend fun pokemonList(offset: Int, limit: Int): Response<NamedApiResourceList> =
    api.getPokemonList(offset, limit)

}