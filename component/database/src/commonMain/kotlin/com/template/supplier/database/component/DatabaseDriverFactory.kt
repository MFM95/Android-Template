package com.template.supplier.database.component

import com.squareup.sqldelight.db.SqlDriver


expect class DatabaseDriverFactory {
    fun create(): SqlDriver
}