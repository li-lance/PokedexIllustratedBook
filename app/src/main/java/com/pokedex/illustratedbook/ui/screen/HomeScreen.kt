package com.pokedex.illustratedbook.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.pokedex.illustratedbook.naviation.Route.PokemonList

@Composable
fun HomeScreen(navController: NavHostController) {
  Surface(color = MaterialTheme.colors.background) {
    Text(text = "Hello Android!", Modifier.clickable {
      navController.navigate(PokemonList.route)
    })
  }
}