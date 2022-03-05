package com.template.supplier.auth.domain.interactor



import com.template.supplier.auth.domain.AuthRepository
import com.template.supplier.auth.domain.entity.User
import com.template.supplier.core.component.dispatcher.DomainDispatcher
import kotlinx.coroutines.withContext

class SignInUseCase(
    private val dispatcher: DomainDispatcher,
    private val repository: AuthRepository
) {

    suspend operator fun invoke(userName: String, password: String): User =
        withContext(dispatcher) {
            repository.signIn(userName, password)
        }

}