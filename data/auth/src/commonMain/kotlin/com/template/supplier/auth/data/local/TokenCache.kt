package com.template.supplier.auth.data.local

import com.russhwolf.settings.Settings

import com.template.supplier.api.component.AccessToken
import com.template.supplier.api.component.AccessTokenProvider
import kotlinx.serialization.json.Json


class TokenCache(private val settings: Settings) : AccessTokenProvider {
    override fun provide(): AccessToken? {
        return settings.getStringOrNull(TokenKey)?.fromJson()
    }

    fun put(accessToken: AccessToken) {
        accessToken.toJson()
            .also {
                settings.putString(TokenKey, it)
            }
    }

    fun clear() {
        settings.remove(TokenKey)
    }

    private fun String.fromJson(): AccessToken =
        Json.decodeFromString(AccessToken.serializer(), this)

    private fun AccessToken.toJson(): String = Json.encodeToString(AccessToken.serializer(), this)

    companion object {
        private const val TokenKey = "access_token"
    }
}

