package com.template.supplier.auth.data.local

import com.template.supplier.database.component.DatabaseManager


class DatabaseCache(
    private val databaseManager: DatabaseManager
) {
    fun clear() {
        databaseManager.drop()
    }
}