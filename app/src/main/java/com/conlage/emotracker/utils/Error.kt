@file:OptIn(ExperimentalCoroutinesApi::class)

package com.conlage.emotracker.utils

import android.content.Context
import com.conlage.emotracker.R
import com.conlage.emotracker.common.RequestResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.ProducerScope
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

fun <T> flow(
   context: Context,
   block: suspend FlowCollector<RequestResult<T>>.() -> Unit
): Flow<RequestResult<T>> = flow {
   try {
      block()
   } catch (e: Exception) {
      emitError<T>(e.errorMessage(context = context))
   }
}

fun java.lang.Exception.errorMessage(
   context: Context
): String {
   println("Error: $this")
   return when (this) {
      is HttpException -> this.response()?.errorBody()?.string()
         ?: context.getString(R.string.unknown_error_message)
      is IOException -> context.getString(R.string.internet_connection_error_message)
      else -> context.getString(R.string.unknown_error_message)
   }
}

suspend fun <T> FlowCollector<RequestResult<T>>.emitSuccess(data: T) =
   emit(RequestResult.Success(data))

suspend fun FlowCollector<RequestResult<Unit>>.emitSuccess() {
   emit(RequestResult.Success(Unit))
}

suspend fun <T> FlowCollector<RequestResult<T>>.emitError(errorMessage: String) =
   emit(RequestResult.Error(errorMessage))
