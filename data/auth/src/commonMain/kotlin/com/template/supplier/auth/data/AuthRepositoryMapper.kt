package com.template.supplier.auth.data


import model.user.UserModel


internal fun mapToSignInRequest(username: String, password: String): SignInRequest =
    SignInRequest(username, password)

internal fun mapToAccessToken(userId: String, token: String): AccessToken =
    AccessToken(userId, token)

internal fun SignInResponse.toDomain(): User =
    User(
        id = userId,
        name = username,
    )

internal fun UserModel.toDomain(): User =
    User(
        id = id,
        name = name,
    )

internal fun SignInResponse.toLocal(): UserModel =
    UserModel(
        id = userId,
        name = username,
    )