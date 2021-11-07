package com.pokedex.illustratedbook.model

data class ErrorResponse(val code: Int, override val message: String) : Throwable("($code) $message")
