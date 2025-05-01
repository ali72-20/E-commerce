package com.example.e_commerce.core

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.e_commerce.fragments.home.HomeFragment
import com.example.e_commerce.fragments.login.LoginFragment
import com.example.e_commerce.fragments.register.RegisterFragment

@Composable
fun AppNavigationManager() {
    val navController = rememberNavController()

    NavHost(navController,startDestination = AppRoutes.Login.route){
        composable(AppRoutes.Login.route) {
            LoginFragment()
        }
        composable(AppRoutes.Register.route) {
            RegisterFragment()
        }
        composable(AppRoutes.Home.route){
            HomeFragment()
        }
    }
}