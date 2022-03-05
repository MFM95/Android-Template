package com.template.supplier.api.component

import com.template.api.component.ApiConfig

internal actual fun provideApiConfig(): ApiConfig =
    when {
        BuildConfig.DEBUG -> ApiConfig.Development
        else -> ApiConfig.Production
    }
