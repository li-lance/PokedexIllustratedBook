package com.pokedex.illustratedbook.ui.screen.pokemon.list

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.fate.android.log.LoggerUtils
import com.pokedex.illustratedbook.api.ApiService
import com.pokedex.illustratedbook.data.PokemonEntity
import com.pokedex.illustratedbook.data.toPokemonEntity
import com.pokedex.illustratedbook.repository.PokemonRepository

class PokemonSource(private val repository: PokemonRepository) :
  PagingSource<Int, PokemonEntity>() {
  override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonEntity> {
    return try {
      val nextPage = params.key ?: 0
      val response = repository.pokemonList(nextPage, params.loadSize).body()
      val result = response?.results ?: emptyList()
      val list = mutableListOf<PokemonEntity>()
      result.forEach {
        list.add(it.toPokemonEntity())
      }
      LoadResult.Page(
        data = list,
        prevKey = if (nextPage > 0) nextPage - 1 else null,
        nextKey = if (result.size == params.loadSize) nextPage + 1 else null
      )
    } catch (e: Exception) {
      LoadResult.Error(e)
    }
  }

  override fun getRefreshKey(state: PagingState<Int, PokemonEntity>): Int? {
    return state.anchorPosition?.let {
      state.closestPageToPosition(it)?.prevKey?.plus(1)
        ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
    }
  }
}