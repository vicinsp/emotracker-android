package com.conlage.emotracker.common

sealed class RequestResult<T> {

   data class Success<T>(val data: T) : RequestResult<T>()
   data class Error<T>(val errorMessage: String) : RequestResult<T>()
}