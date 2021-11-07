package com.pokedex.illustratedbook.repository

import com.pokedex.illustratedbook.model.ErrorResponse

sealed class Resource<T> {
  class Success<T>(val data: T) : Resource<T>()
  class Failed<T>(val error: ErrorResponse) : Resource<T>()
}