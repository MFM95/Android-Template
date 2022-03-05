package com.template.supplier.auth.domain.interactor


import com.template.supplier.auth.domain.AuthRepository
import com.template.supplier.core.component.dispatcher.DomainDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flowOn

class IsUserSignedInUseCase(
    private val dispatcher: DomainDispatcher,
    private val repository: AuthRepository
) {

    suspend operator fun invoke(): Boolean =
        repository.getUser()
            .flowOn(dispatcher)
            .firstOrNull() != null

}