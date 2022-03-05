package com.template.supplier.database.component

import model.user.UserModelQueries


internal const val DB_NAME = "supplier.db"

class DatabaseManager(
    private val userModelQueries: UserModelQueries,
) {

    fun drop() {
        userModelQueries.deleteAll()
    }
}
