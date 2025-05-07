package com.example.e_commerce.login

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavController
import androidx.navigation.compose.ComposeNavigator
import androidx.test.core.app.ApplicationProvider
import com.example.e_commerce.fragments.login.LoginScreen
import org.junit.Rule
import org.junit.Test

class LoginFragmentUiTesting {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun clickText_navigateToRegisterScreen(){

        val context = ApplicationProvider.getApplicationContext<android.content.Context>()
        val navController = TestNavHostController(context)

        composeTestRule.setContent {
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            LoginScreen(navController = navController)
        }

        composeTestRule.onNodeWithText("Create Account").performClick()
    }
}