package com.template.supplier.api.component

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.ios.Ios

internal actual fun provideHttpClientEngine(): HttpClientEngine = Ios.create()
