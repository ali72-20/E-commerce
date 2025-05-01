package com.example.e_commerce.core

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavigationManager() {
    val navController = rememberNavController()

    NavHost(navController,startDestination = AppRoutes.Login.route){
        composable(AppRoutes.Login.route) {

        }
        composable(AppRoutes.Register.route) {

        }
        composable(AppRoutes.Home.route){

        }
    }
}