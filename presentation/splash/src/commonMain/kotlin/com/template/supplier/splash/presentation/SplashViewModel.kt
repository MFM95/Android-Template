package com.template.supplier.splash.presentation

import com.template.supplier.auth.domain.interactor.IsUserSignedInUseCase
import com.template.supplier.core.component.exception.ApiException
import com.template.supplier.presentation.component.EventHandler
import com.template.supplier.presentation.component.SideEffectHandler
import kotlinx.coroutines.launch

class SplashViewModel(private val isUserSignedInUseCase: IsUserSignedInUseCase) :
    SideEffectHandler<SplashSideEffect>(), EventHandler<SplashViewEvent> {

    override fun onEvent(event: SplashViewEvent) {
        when (event) {
            is SplashViewEvent.Start -> scope.launch {
                try {
                    when (isUserSignedInUseCase()) {
                        true -> emitEffect(SplashSideEffect.GoToHome)
                        false -> emitEffect(SplashSideEffect.GoToOnBoarding)
                    }
                } catch (e: ApiException) {
                    emitEffect(SplashSideEffect.GoToOnBoarding)
                }
            }
        }
    }
}