package com.template.supplier

import android.app.Application
import android.content.Context
import com.template.supplier.di.SupplierAppDI
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.androidCoreModule
import org.kodein.di.bindSingleton

class TemplateApp : Application(), DIAware {
    override val di by DI.lazy {
        import(androidCoreModule(this@TemplateApp))
        import(module = SupplierAppDI.module)
        bindSingleton<Context> { this@TemplateApp }
    }
}