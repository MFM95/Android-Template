package com.template.supplier.screen.auth.di


import com.template.supplier.auth.domain.di.AuthDomainDI
import org.kodein.di.DI

object AuthFeatureDI {
    val module = DI.Module("Auth Feature Module") {
        import(module = AuthDomainDI.module)
        import(module = AuthDataDI.module)
        import(module = AuthLocalDI.module)
        import(module = AuthRemoteDI.module)
    }
}