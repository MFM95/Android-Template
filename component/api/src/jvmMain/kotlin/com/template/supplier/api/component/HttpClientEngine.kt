package com.template.supplier.api.component

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.java.Java

internal actual fun provideHttpClientEngine(): HttpClientEngine = Java.create()
