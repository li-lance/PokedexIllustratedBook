package com.pokedex.illustratedbook.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pokedex.illustratedbook.model.NamedApiResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.pokemonCache: DataStore<Preferences> by preferencesDataStore("pokemon")
internal fun NamedApiResource.toPokemonEntity(): PokemonEntity = PokemonEntity(
  this.name,
  "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${
    url.split(
      "/".toRegex()
    ).dropLast(1).last()
  }.png"
)

val POKEMON_LIST = stringPreferencesKey("pokemon_list")

internal suspend fun savePokemonList(context: Context, list: MutableList<PokemonEntity>) {
  context.pokemonCache.edit {
    val data = Gson().toJson(list) ?: ""
    it[POKEMON_LIST] = data
  }
}

internal fun getPokemonList(context: Context): Flow<List<PokemonEntity>> {
  return context.pokemonCache.data.map {
    val json = it[POKEMON_LIST]
    Gson().fromJson(json, object : TypeToken<List<PokemonEntity>>() {}.type)
  }
}
