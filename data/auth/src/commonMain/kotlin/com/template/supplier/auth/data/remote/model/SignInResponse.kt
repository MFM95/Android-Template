package com.template.supplier.auth.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SignInResponse(
    @SerialName("AccessToken")
    val accessToken: String,
    @SerialName("userId")
    val userId: String,
    @SerialName("UserName")
    val username: String
)