package com.pokedex.illustratedbook.ui.screen.pokemon

import androidx.lifecycle.ViewModel
import com.pokedex.illustratedbook.repository.PokemonRepository
import com.pokedex.illustratedbook.repository.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(private val repository: PokemonRepository) : ViewModel() {
  suspend fun getPokemonList() {
    repository.pokemonList(0, 20).collect { state ->
      when (state) {
        is Resource.Success -> {

        }
        is Resource.Failed -> {

        }
      }
    }
  }
}