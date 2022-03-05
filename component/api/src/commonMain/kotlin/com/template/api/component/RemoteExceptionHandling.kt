package com.template.api.component

import com.template.supplier.core.component.exception.ApiException
import io.ktor.client.HttpClientConfig
import io.ktor.client.call.receive
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.HttpResponseValidator
import io.ktor.client.features.ResponseException
import io.ktor.client.features.ServerResponseException
import io.ktor.client.statement.readText
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
private data class Error(
    @SerialName("Message")
    val message: String,
)

internal fun HttpClientConfig<*>.setupExceptionHandler() {
    HttpResponseValidator {
        handleResponseException { cause ->
            val responseException = cause as? ResponseException
            if (responseException != null) {
                val response = responseException.response
                val status = response.status
                val exception = try {
                    val error = response.receive<Error>()
                    val message = error.message
                    when (responseException) {
                        is ClientRequestException -> ApiException.Client(message)
                        is ServerResponseException -> ApiException.Server(message)
                        else -> ApiException.General(message)
                    }
                } catch (cause: Throwable) {
                    val content = response.readText()
                    ApiException.General(content)
                }
                Logger.log("Response Exception: $status - ${exception.message}")
                throw exception
            } else {
                throw ApiException.Connection
            }
        }
    }
}
