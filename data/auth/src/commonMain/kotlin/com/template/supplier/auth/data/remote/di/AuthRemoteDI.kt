package com.template.supplier.auth.data.remote.di

import com.template.supplier.auth.data.remote.AuthAPI
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.instance

object AuthRemoteDI {
    val module = DI.Module("Auth Remote Module") {
        bindProvider { AuthAPI(instance()) }
    }

}