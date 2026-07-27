package com.jacobscher.androidcomposedemo

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Unit tests for [CounterViewModel].
 * Demonstrates testing StateFlow with kotlinx-coroutines-test.
 */
@OptIn(ExperimentalCoroutinesApi::class)
class CounterViewModelTest {

    private lateinit var viewModel: CounterViewModel

    @Before
    fun setup() {
        viewModel = CounterViewModel()
    }

    @Test
    fun `initial count is zero`() = runTest {
        assertEquals(0, viewModel.count.first())
    }

    @Test
    fun `increment increases count by one`() = runTest {
        viewModel.increment()
        assertEquals(1, viewModel.count.first())

        viewModel.increment()
        assertEquals(2, viewModel.count.first())
    }

    @Test
    fun `decrement decreases count but not below zero`() = runTest {
        viewModel.increment()
        viewModel.increment()
        assertEquals(2, viewModel.count.first())

        viewModel.decrement()
        assertEquals(1, viewModel.count.first())

        viewModel.decrement()
        assertEquals(0, viewModel.count.first())

        // Should stay at 0
        viewModel.decrement()
        assertEquals(0, viewModel.count.first())
    }

    @Test
    fun `reset sets count back to zero`() = runTest {
        viewModel.increment()
        viewModel.increment()
        viewModel.increment()
        assertEquals(3, viewModel.count.first())

        viewModel.reset()
        assertEquals(0, viewModel.count.first())
    }
}
