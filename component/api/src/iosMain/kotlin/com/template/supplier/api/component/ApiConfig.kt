package com.template.supplier.api.component

import com.template.api.component.ApiConfig

internal actual fun provideApiConfig(): ApiConfig =
    when {
        Platform.isDebugBinary -> ApiConfig.Development
        else -> ApiConfig.Production
    }
