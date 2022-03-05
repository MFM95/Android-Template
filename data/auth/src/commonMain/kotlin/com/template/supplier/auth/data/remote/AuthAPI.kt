package com.template.supplier.auth.data.remote

import io.ktor.client.*
import io.ktor.client.request.*

import com.template.supplier.auth.data.remote.model.SignInRequest
import com.template.supplier.auth.data.remote.model.SignInResponse

internal class AuthAPI(private val httpClient: HttpClient) {

    suspend fun signIn(request: SignInRequest): SignInResponse =
        httpClient.post(SIGN_IN_PATH, body = request)

    companion object {
        private const val SIGN_IN_PATH = "/SignIn"
    }
}

