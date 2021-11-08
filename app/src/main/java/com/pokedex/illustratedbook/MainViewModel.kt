package com.pokedex.illustratedbook

import android.util.Log
import androidx.lifecycle.ViewModel
import com.pokedex.illustratedbook.repository.PokemonRepository
import com.pokedex.illustratedbook.repository.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: PokemonRepository) : ViewModel() {
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