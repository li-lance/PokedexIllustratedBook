package com.pokedex.illustratedbook.ui.screen.pokemon.list

import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.pokedex.illustratedbook.ui.screen.pokemon.PokemonViewModel

@Composable
fun PokemonListScreen() {
  val viewModel = hiltViewModel<PokemonViewModel>()
  Surface {
    Text(text = "Hello My Pokemon!")
  }
}