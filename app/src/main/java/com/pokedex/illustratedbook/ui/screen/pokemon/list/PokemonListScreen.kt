package com.pokedex.illustratedbook.ui.screen.pokemon.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextAlign.Companion
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import coil.compose.rememberImagePainter
import com.fate.android.log.LoggerUtils
import com.pokedex.illustratedbook.data.PokemonEntity
import com.pokedex.illustratedbook.ui.screen.pokemon.PokemonViewModel
import kotlinx.coroutines.flow.Flow

@Composable
fun PokemonListScreen() {
  val viewModel = hiltViewModel<PokemonViewModel>()
  Surface {
    PokemonList(list = viewModel.getPokemonList())
  }
}

@Composable
fun PokemonList(list: Flow<PagingData<PokemonEntity>>) {
  val lazyPagingItems: LazyPagingItems<PokemonEntity> = list.collectAsLazyPagingItems()
  LazyColumn {
    if (lazyPagingItems.loadState.refresh == LoadState.Loading) {
      item {
        Text(
          text = "Waiting for items to load from the backend",
          modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .wrapContentWidth(Alignment.CenterHorizontally)
            .wrapContentHeight(Alignment.CenterVertically)

        )
      }
    }
    itemsIndexed(lazyPagingItems) { _, item ->
      item?.let {
        PokemonItem(pokemon = it)
      }
    }
    if (lazyPagingItems.loadState.append == LoadState.Loading) {
      item {
        CircularProgressIndicator(
          modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
        )
      }
    }
  }
}

@Composable
fun PokemonItem(pokemon: PokemonEntity) {
  Row(
    modifier = Modifier
      .padding(start = 16.dp, top = 16.dp, end = 16.dp)
      .fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(text = pokemon.name)
    Image(
      painter = rememberImagePainter(pokemon.image),
      contentDescription = null,
      modifier = Modifier.size(128.dp)
    )
  }
}