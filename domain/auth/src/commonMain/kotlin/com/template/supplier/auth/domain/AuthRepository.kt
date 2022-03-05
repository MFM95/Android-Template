package com.template.supplier.auth.domain

import com.template.supplier.auth.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun signIn(username: String, password: String): User
    suspend fun getUser(): Flow<User?>
}