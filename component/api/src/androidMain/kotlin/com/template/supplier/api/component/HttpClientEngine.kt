package com.template.supplier.api.component

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.android.Android

internal actual fun provideHttpClientEngine(): HttpClientEngine = Android.create()
