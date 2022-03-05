package com.template.api.component

import com.template.supplier.api.component.AccessTokenProvider
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine

internal class HttpClientProvider constructor(
    private val apiConfig: ApiConfig,
    private val accessTokenProvider: AccessTokenProvider,
    private val engine: HttpClientEngine,
) {

    fun provide(): HttpClient =
        HttpClient(engine) {
            setupDefaultRequest(apiConfig, accessTokenProvider)
            setupJson()
            setupLogging()
            setupExceptionHandler()
        }
}
