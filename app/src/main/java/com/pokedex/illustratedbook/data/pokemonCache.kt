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
import com.pokedex.illustratedbook.model.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.pokemonCache: DataStore<Preferences> by preferencesDataStore("pokemon")
internal fun NamedApiResource.toPokemonEntity(): PokemonEntity = PokemonEntity(
  this.name,
  "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${
    url.split(
      "/".toRegex()
    ).dropLast(1).last()
  }.png"
)

internal fun Pokemon.toPokemonEntity(): PokemonEntity = PokemonEntity(
  this.name,
  "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${
    this.id
  }.png"
)
interface PokemonCache {
  suspend fun savePokemonList(list: MutableList<PokemonEntity>)
  fun getPokemonList(): Flow<List<PokemonEntity>>
  suspend fun savePokemon(pokemon: Pokemon)
  fun getPokemon(): Flow<PokemonEntity>
}
class PokemonCacheImpl(private val context: Context, private val gson: Gson) : PokemonCache {
  companion object {
    private val POKEMON_LIST = stringPreferencesKey("pokemon_list")
    private val POKEMON = stringPreferencesKey("pokemon")
  }

  override suspend fun savePokemonList(list: MutableList<PokemonEntity>) {
    context.pokemonCache.edit {
      val data = gson.toJson(list) ?: ""
      it[POKEMON_LIST] = data
    }
  }

  override fun getPokemonList(): Flow<List<PokemonEntity>> {
    return context.pokemonCache.data.map {
      val json = it[POKEMON_LIST]
      gson.fromJson(json, object : TypeToken<List<PokemonEntity>>() {}.type)
    }
  }

  override suspend fun savePokemon(pokemon: Pokemon) {
    context.pokemonCache.edit {
      val data = gson.toJson(pokemon) ?: ""
      it[POKEMON] = data
    }
  }

  override fun getPokemon(): Flow<PokemonEntity> {
    return context.pokemonCache.data.map {
      val json = it[POKEMON]
      gson.fromJson(json, Pokemon::class.java).toPokemonEntity()
    }
  }
}




