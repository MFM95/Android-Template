package com.template.signin


import com.template.supplier.auth.domain.interactor.SignInUseCase
import com.template.supplier.core.component.exception.ApiException
import com.template.supplier.presentation.component.EventHandler
import com.template.supplier.presentation.component.StateHandler
import com.template.supplier.presentation.component.StringProvider
import kotlinx.coroutines.launch

class SignInViewModel(
    private val signIn: SignInUseCase,
    private val stringProvider: StringProvider
) :
    EventHandler<SignInViewEvent>,
    StateHandler<SignInViewState, SignInSideEffect>(initialState = SignInViewState.Initial) {
    override fun onEvent(event: SignInViewEvent) {
        when (event) {
            is SignInViewEvent.SignIn -> scope.launch {
                if (validateFields(event)) {
                    updateState(
                        state.value.copy(
                            isLoading = true,
                        )
                    )
                    try {
                        signIn(event.userName, event.password)
                        updateState(
                            state.value.copy(
                                isLoading = false,
                            )
                        )
                        emitEffect(SignInSideEffect.GoToHome)
                    } catch (e: ApiException) {
                        updateState(
                            state.value.copy(
                                isLoading = false,
                                errorMessage = stringProvider.generalError
                            )
                        )
                    }
                }
            }
        }
    }

    private fun validateFields(event: SignInViewEvent.SignIn): Boolean {
        val isUsernameValid = event.userName.isNotBlank()
        val isPasswordValid = event.password.isNotBlank()
        val isValid = isUsernameValid && isPasswordValid
        updateState(
            state.value.copy(
                isUsernameError = !isUsernameValid,
                isPasswordError = !isPasswordValid,
                errorMessage = null
            )
        )
        return isValid
    }

}