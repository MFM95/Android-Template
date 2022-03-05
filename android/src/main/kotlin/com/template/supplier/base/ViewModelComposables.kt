package com.template.supplier.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.template.supplier.presentation.component.SideEffectHandler
import com.template.supplier.presentation.component.StateHandler

import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.kodein.di.Instance
import org.kodein.di.compose.localDI
import org.kodein.type.generic
/**
 * Composable with [StateHandler] provided with its [State].
 */
@Composable
inline fun <reified ViewModel : StateHandler<State, *>, State> ComposeViewModel(
    noinline compose: @Composable (viewModel: ViewModel, state: androidx.compose.runtime.State<State>) -> Unit
) {
    /** `rememberInstance()` requires a `reified` generic [ViewModel] type and this function as `inline`. */
    val viewModel: ViewModel = rememberInstance()
    /** Attach the view model's coroutine scope to the [ComposeViewModel]'s consumer lifecycle */
    viewModel.scope = rememberCoroutineScope()
    /**
     * We have to keep the [compose] lambda as `noinline`
     * so we make the recomposition for state changes run in the [compose] scope only.
     */
    val state = viewModel.state.collectAsState()

    compose(viewModel, state)
}

/**
 * Composable with [SideEffectHandler] provided.
 */
@Composable
inline fun <reified ViewModel : SideEffectHandler<*>> ComposeViewModel(
    noinline compose: @Composable (viewModel: ViewModel) -> Unit
) {
    /** `rememberInstance()` requires a `reified` generic [ViewModel] type and this function as `inline`. */
    val viewModel: ViewModel = rememberInstance()
    /** Attach the view model's coroutine scope to the [ComposeViewModel]'s consumer lifecycle */
    viewModel.scope = rememberCoroutineScope()

    compose(viewModel)
}

@Composable
fun <SideEffect> OnSideEffect(
    sideEffectHandler: SideEffectHandler<SideEffect>,
    onEffect: (effect: SideEffect) -> Unit
) {
    LaunchedEffect(sideEffectHandler) {
        sideEffectHandler.effect
            .onEach(onEffect)
            .launchIn(sideEffectHandler.scope)
    }
}

@Composable
inline fun <reified T> rememberInstance(): T {
    val instance: T by localDI().Instance(generic())
    return remember { instance }
}
