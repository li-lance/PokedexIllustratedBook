package com.pokedex.illustratedbook

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun PokemonListScreen(){
  Surface(color = MaterialTheme.colors.background) {
    Text(text = "Hello My Pokemon!")  }
}