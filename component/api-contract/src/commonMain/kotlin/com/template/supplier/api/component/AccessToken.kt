package com.template.supplier.api.component

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccessToken(
    @SerialName("userId")
    val userId: String,
    @SerialName("token")
    val token: String
)