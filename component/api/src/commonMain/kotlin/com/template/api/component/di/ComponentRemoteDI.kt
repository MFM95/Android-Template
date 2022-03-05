package com.template.api.component.di

import com.template.api.component.HttpClientProvider
import com.template.api.component.provideApiConfig
import com.template.api.component.provideHttpClientEngine
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.bindSingleton
import org.kodein.di.instance

object ComponentRemoteDI {
    val module = DI.Module("Remote Module") {
        bindProvider { provideApiConfig() }
        bindProvider { provideHttpClientEngine() }
        bindProvider {
            HttpClientProvider(
                instance(),
                instance(),
                instance()
            )
        }
        bindSingleton {
            instance<HttpClientProvider>().provide()
        }
    }
}
