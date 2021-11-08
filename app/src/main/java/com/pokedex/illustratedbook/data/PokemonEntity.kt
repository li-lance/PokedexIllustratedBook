package com.pokedex.illustratedbook.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonEntity(val name:String,val image:String) : Parcelable