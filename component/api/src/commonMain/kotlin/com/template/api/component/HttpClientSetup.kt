package com.template.api.component

import com.template.supplier.api.component.AccessTokenProvider
import io.ktor.client.HttpClientConfig
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.accept
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import kotlinx.serialization.json.Json

private val json = Json {
    prettyPrint = true
    isLenient = true
    ignoreUnknownKeys = true
    encodeDefaults = true
}

private val HttpHeaders.AccessToken: String get() = "AccessToken"

internal fun HttpClientConfig<*>.setupDefaultRequest(
    apiConfig: ApiConfig,
    accessTokenProvider: AccessTokenProvider
) {
    defaultRequest {
        url {
            protocol = apiConfig.protocol
            host = apiConfig.host
            port = apiConfig.port
        }
        header(HttpHeaders.AccessToken, accessTokenProvider.provide())
        header(HttpHeaders.ContentType, ContentType.Application.Json)
        accept(ContentType.Application.Json)
    }
}

internal fun HttpClientConfig<*>.setupJson() {
    install(JsonFeature) {
        serializer = KotlinxSerializer(json)
    }
}

internal fun HttpClientConfig<*>.setupLogging() {
    install(Logging) {
        logger = Logger
        level = LogLevel.ALL
    }
}
