package com.example.e_commerce.core

sealed class AppRoutes(val route: String) {
    class Home() : AppRoutes("home")
    class Login() : AppRoutes("Login")
    class Register(): AppRoutes("Register")
}