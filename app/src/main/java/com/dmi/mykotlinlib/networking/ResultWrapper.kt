package com.dmi.mykotlinlib.networking

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class Error(val message: String, val cause: Exception? = null) : ResultWrapper<Nothing>()
}
