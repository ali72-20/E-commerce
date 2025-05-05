package com.example.e_commerce.core.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.e_commerce.fragments.login.LoginFragment
import com.example.e_commerce.fragments.register.RegisterFragment
import kotlinx.serialization.Serializable


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login){
        composable<Login>{
            LoginFragment(navController = navController)
        }
        composable<Register> {
            RegisterFragment()
        }
    }
}


@Serializable
object Home
@Serializable
object Login
@Serializable
object Register
