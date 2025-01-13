package com.example.uikit.common.base

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.koin.core.component.KoinComponent

abstract class BaseMviViewModel<A, V: Any, N: Any>: ViewModel(), KoinComponent {
    var viewState by mutableStateOf(initialState)
    abstract var initialState: V
    lateinit var navigation: N

    abstract fun initViewState()
    abstract fun initNavigation(navigation: N)

    abstract fun dispatcherViewAction(action: A)
}