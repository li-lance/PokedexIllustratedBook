package com.pokedex.illustratedbook.naviation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pokedex.illustratedbook.PokemonListScreen
import com.pokedex.illustratedbook.ui.screen.HomeScreen
import com.pokedex.illustratedbook.ui.theme.PokedexIllustratedBookTheme

sealed class Route(val route: String) {
  object Home : Route("Home")
  object PokemonList : Route("PokemonList")
}
@Composable
fun RouteConfigurations(navController: NavHostController) {
  NavHost(navController = navController, startDestination = Route.Home.route) {
    composable(Route.Home.route) {
      PokedexIllustratedBookTheme {
        HomeScreen(navController)
      }
    }
    composable(Route.PokemonList.route) {
        PokemonListScreen()
    }
  }
}