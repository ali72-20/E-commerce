package com.example.e_commerce.core.navigation

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.e_commerce.fragments.login.LoginScreen
import com.example.e_commerce.fragments.register.RegisterFragment
import com.example.e_commerce.fragments.register.RegisterScreen

import kotlinx.serialization.Serializable


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login){
        composable<Login>{
            LoginScreen(navController = navController)
        }
        composable<Register> {
            RegisterScreen(navController = navController)
        }
    }
}


@Serializable
object Home
@Serializable
object Login
@Serializable
object Register
