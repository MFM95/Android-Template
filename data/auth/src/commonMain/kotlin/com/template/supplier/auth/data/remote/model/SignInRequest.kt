package com.template.supplier.auth.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SignInRequest(
    @SerialName("UserName")
    val username: String,
    @SerialName("Password")
    val password: String
)