package com.template.supplier.presentation.component

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

abstract class CoroutineScopeHolder {
    lateinit var scope: CoroutineScope
}

interface EventHandler<Event> {
    fun onEvent(event: Event)
}

abstract class SideEffectHandler<SideEffect> : CoroutineScopeHolder() {

    private val _effect = MutableSharedFlow<SideEffect>()
    val effect: SharedFlow<SideEffect> = _effect

    suspend fun emitEffect(newEffect: SideEffect) {
        _effect.emit(newEffect)
    }

    fun tryEmitEffect(newEffect: SideEffect) {
        _effect.tryEmit(newEffect)
    }
}

abstract class StateHandler<State, Event>(initialState: State) : SideEffectHandler<Event>() {

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<State> = _state

    protected fun updateState(newState: State) {
        _state.value = newState
    }
}
