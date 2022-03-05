package com.template.supplier.auth.data.local.di

import com.russhwolf.settings.Settings
import com.template.supplier.api.component.AccessTokenProvider

import com.template.supplier.auth.data.local.DatabaseCache
import com.template.supplier.auth.data.local.TokenCache
import com.template.supplier.auth.data.local.UserCache
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.bindSingleton
import org.kodein.di.instance

object AuthLocalDI {
    val module = DI.Module("Auth Local Module") {
        bindSingleton { Settings() }
        bindProvider { DatabaseCache(instance()) }
        bindProvider { TokenCache(instance()) }
        bindProvider { UserCache(instance(), instance()) }
        bindProvider<AccessTokenProvider> { instance<TokenCache>() }
    }

}