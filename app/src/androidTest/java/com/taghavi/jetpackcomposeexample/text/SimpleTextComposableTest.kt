package com.taghavi.jetpackcomposeexample.text

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SimpleTextComposableTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent { SimpleText("Learn Compose By Example") }
    }

    @Test
    fun check_if_app_launched_and_displayed_text() {
        composeTestRule.onNodeWithText("Learn Compose By Example").assertIsDisplayed()
    }
}