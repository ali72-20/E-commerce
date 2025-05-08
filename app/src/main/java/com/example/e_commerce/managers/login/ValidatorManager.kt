package com.example.e_commerce.managers.login

class ValidatorManager {
    fun validateEmail(email: String): Boolean {
        val emailRegex = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
        return emailRegex.matches(email)
    }
    fun validatePassword(password:String): Boolean{
        return password.length>=8
    }
}