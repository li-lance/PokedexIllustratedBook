package com.pokedex.illustratedbook

import androidx.lifecycle.ViewModel
import com.pokedex.illustratedbook.repository.PokemonRepository
import com.pokedex.illustratedbook.repository.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
}