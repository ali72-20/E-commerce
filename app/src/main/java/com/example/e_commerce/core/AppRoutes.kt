package com.example.e_commerce.core

sealed class AppRoutes(val route:String) {
    data object Home: AppRoutes("home")
    data object Login : AppRoutes("Login")
    data object Register: AppRoutes("Register")
}