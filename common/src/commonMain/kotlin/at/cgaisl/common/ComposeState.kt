package at.cgaisl.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.experimental.ExperimentalObjCRefinement

interface ComposeState<T> {
    @get:Composable
    val state: State<T>
}

@
class ComposeStateImplementation<T>(
    value: T,
) : ComposeState<T> {
    private val _state = MutableStateFlow(value)


    override val state: State<T>
        @Composable
        get() = _state.collectAsState()

    fun update(value: T) {
        _state.value = value
    }
}