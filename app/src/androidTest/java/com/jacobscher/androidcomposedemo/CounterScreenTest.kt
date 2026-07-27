package com.jacobscher.androidcomposedemo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jacobscher.androidcomposedemo.ui.CounterContent
import com.jacobscher.androidcomposedemo.ui.theme.AndroidComposeDemoTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented Compose UI tests for the counter screen.
 * Uses testTags for reliable node selection and mutable state for interaction verification.
 */
@RunWith(AndroidJUnit4::class)
class CounterScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun counterStartsAtZero() {
        composeTestRule.setContent {
            AndroidComposeDemoTheme {
                CounterContent(
                    count = 0,
                    onIncrement = {},
                    onDecrement = {},
                    onReset = {}
                )
            }
        }

        composeTestRule
            .onNodeWithTag("count_text")
            .assertTextEquals("Count: 0")
    }

    @Test
    fun incrementButtonIncreasesCount() {
        composeTestRule.setContent {
            var count by remember { mutableIntStateOf(0) }

            AndroidComposeDemoTheme {
                CounterContent(
                    count = count,
                    onIncrement = { count++ },
                    onDecrement = { if (count > 0) count-- },
                    onReset = { count = 0 }
                )
            }
        }

        composeTestRule.onNodeWithTag("count_text").assertTextEquals("Count: 0")

        composeTestRule.onNodeWithTag("increment_button").performClick()
        composeTestRule.onNodeWithTag("count_text").assertTextEquals("Count: 1")

        composeTestRule.onNodeWithTag("increment_button").performClick()
        composeTestRule.onNodeWithTag("count_text").assertTextEquals("Count: 2")
    }

    @Test
    fun decrementAndResetWork() {
        composeTestRule.setContent {
            var count by remember { mutableIntStateOf(3) }

            AndroidComposeDemoTheme {
                CounterContent(
                    count = count,
                    onIncrement = { count++ },
                    onDecrement = { if (count > 0) count-- },
                    onReset = { count = 0 }
                )
            }
        }

        composeTestRule.onNodeWithTag("count_text").assertTextEquals("Count: 3")

        composeTestRule.onNodeWithTag("decrement_button").performClick()
        composeTestRule.onNodeWithTag("count_text").assertTextEquals("Count: 2")

        composeTestRule.onNodeWithTag("reset_button").performClick()
        composeTestRule.onNodeWithTag("count_text").assertTextEquals("Count: 0")
    }

    @Test
    fun allButtonsArePresent() {
        composeTestRule.setContent {
            AndroidComposeDemoTheme {
                CounterContent(
                    count = 5,
                    onIncrement = {},
                    onDecrement = {},
                    onReset = {}
                )
            }
        }

        composeTestRule.onNodeWithTag("count_text").assertTextEquals("Count: 5")
        composeTestRule.onNodeWithTag("increment_button").assertExists()
        composeTestRule.onNodeWithTag("decrement_button").assertExists()
        composeTestRule.onNodeWithTag("reset_button").assertExists()
    }
}
