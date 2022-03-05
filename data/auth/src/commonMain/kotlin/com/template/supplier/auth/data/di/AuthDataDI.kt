package com.template.supplier.auth.data.di

import com.template.supplier.auth.data.AuthRepositoryImpl
import com.template.supplier.auth.domain.AuthRepository
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.instance

object AuthDataDI {
    val module = DI.Module("Auth Data Module") {
        bindProvider {
            AuthRepositoryImpl(
                instance(),
                instance(),
                instance(),
                instance(),
            )
        }
        bindProvider<AuthRepository> { instance<AuthRepositoryImpl>() }
    }

}