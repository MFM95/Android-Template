package com.template.api.component

import io.ktor.http.URLProtocol

internal sealed class ApiConfig(
    val host: String,
    val port: Int,
    val protocol: URLProtocol
) {
    object Development : ApiConfig(host = "", port = 0, protocol = URLProtocol.HTTPS)
    object Production : ApiConfig(host = "", port = 0, protocol = URLProtocol.HTTPS)
}

internal expect fun provideApiConfig(): ApiConfig
