package com.pokedex.illustratedbook.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonEntity(val name:String) : Parcelable