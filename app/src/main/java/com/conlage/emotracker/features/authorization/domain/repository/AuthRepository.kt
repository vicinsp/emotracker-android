package com.conlage.emotracker.features.authorization.domain.repository

interface AuthRepository {

   suspend fun authorize(email: String, password: String): String
}