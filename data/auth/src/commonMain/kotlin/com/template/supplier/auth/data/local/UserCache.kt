package com.template.supplier.auth.data.local

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToOneOrNull
import com.template.supplier.core.component.dispatcher.DataDispatcher
import kotlinx.coroutines.flow.Flow
import model.user.UserModel
import model.user.UserModelQueries

class UserCache(
    private val dao: UserModelQueries,
    private val dispatcher: DataDispatcher
) {

    fun put(userModel: UserModel) {
        dao.insert(userModel)
    }

    fun get(): Flow<UserModel?> {
        return dao.selectAll()
            .asFlow()
            .mapToOneOrNull(dispatcher)
    }
}