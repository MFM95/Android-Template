package com.template.supplier.auth.data

import com.template.supplier.auth.data.local.TokenCache
import com.template.supplier.auth.data.local.UserCache
import com.template.supplier.auth.data.remote.AuthAPI
import com.template.supplier.auth.data.remote.model.SignInResponse
import com.template.supplier.auth.domain.AuthRepository
import com.template.supplier.auth.domain.entity.User
import com.template.supplier.core.component.dispatcher.DataDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

internal class AuthRepositoryImpl(
    private val dispatcher: DataDispatcher,
    private val api: AuthAPI,
    private val userCache: UserCache,
    private val tokenCache: TokenCache
) : AuthRepository {

    override suspend fun signIn(username: String, password: String): User =
        withContext(dispatcher) {
            mapToSignInRequest(username, password)
                .let { request -> api.signIn(request) }
                .also { saveToCache(it) }
                .toDomain()
        }

    override suspend fun getUser(): Flow<User?> =
        userCache.get()
            .map { it?.toDomain() }
            .flowOn(dispatcher)

    private fun saveToCache(response: SignInResponse) {
        val userModel = response.toLocal()
            .also(userCache::put)
        mapToAccessToken(userModel.id, response.accessToken)
            .also(tokenCache::put)
    }

}