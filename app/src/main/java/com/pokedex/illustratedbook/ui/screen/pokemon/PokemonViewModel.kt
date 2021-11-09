package com.pokedex.illustratedbook.ui.screen.pokemon

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.pokedex.illustratedbook.api.ApiService
import com.pokedex.illustratedbook.data.PokemonEntity
import com.pokedex.illustratedbook.limit
import com.pokedex.illustratedbook.repository.PokemonRepository
import com.pokedex.illustratedbook.ui.screen.pokemon.list.PokemonSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(private val repository: PokemonRepository) : ViewModel() {

  fun getPokemonList(): Flow<PagingData<PokemonEntity>> {
    return Pager(PagingConfig(pageSize = limit())) {
      PokemonSource(repository)
    }.flow
  }
}