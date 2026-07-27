package com.jacobscher.androidcomposedemo

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Simple ViewModel demonstrating unidirectional data flow with StateFlow.
 * Holds the counter state and exposes intent methods.
 */
class CounterViewModel : ViewModel() {

    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count.asStateFlow()

    fun increment() {
        _count.update { it + 1 }
    }

    fun decrement() {
        _count.update { (it - 1).coerceAtLeast(0) }
    }

    fun reset() {
        _count.value = 0
    }
}
