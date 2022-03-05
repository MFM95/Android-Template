package com.template.supplier.di


import com.template.api.component.di.ComponentRemoteDI
import com.template.supplier.database.component.di.ComponentDatabaseDI
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.bindSingleton
import org.kodein.di.instance


object SupplierAppDI {
    val module = DI.Module("Supplier App Module") {
        import(module = ComponentDatabaseDI.module)
        import(module = ComponentRemoteDI.module)
        import(module = SplashFeatureDI.module)
        import(module = SignInFeatureDI.module)
        import(module = AuthFeatureDI.module)

        bindSingleton<DomainDispatcher> { AppDomainDispatcher }
        bindSingleton<DataDispatcher> { AppDataDispatcher }
        bindSingleton { StringProvider(instance()) }
        bindProvider { DatabaseDriverFactory(instance()) }

    }
}