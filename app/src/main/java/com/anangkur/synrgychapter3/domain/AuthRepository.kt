package com.anangkur.synrgychapter3.domain

interface AuthRepository {
    suspend fun login(username: String, password: String): String
    fun saveToken(token: String)
    fun loadToken(): String?
    fun clearToken()
}