package com.template.supplier.database.component.di

import com.template.supplier.database.SupplierDatabase
import com.template.supplier.database.component.DatabaseDriverFactory
import com.template.supplier.database.component.DatabaseManager
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.bindSingleton
import org.kodein.di.instance

object ComponentDatabaseDI {
    val module = DI.Module("Database Module") {
        bindProvider { instance<DatabaseDriverFactory>().create() }
        bindSingleton { SupplierDatabase(instance()) }
        bindProvider { instance<SupplierDatabase>().userModelQueries }

        bindProvider {
            DatabaseManager(
                instance()
            )
        }
    }
}