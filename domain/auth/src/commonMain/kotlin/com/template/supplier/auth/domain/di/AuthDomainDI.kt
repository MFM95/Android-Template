package com.template.supplier.auth.domain.di


import com.template.supplier.auth.domain.interactor.IsUserSignedInUseCase
import com.template.supplier.auth.domain.interactor.SignInUseCase
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.instance

object AuthDomainDI {
    val module = DI.Module("Auth Domain Module") {
        bindProvider {
            IsUserSignedInUseCase(
                instance(),
                instance()
            )
        }
        bindProvider {
            SignInUseCase(
                instance(),
                instance()
            )
        }
    }
}
