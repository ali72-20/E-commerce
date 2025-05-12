package com.example.e_commerce.managers.login

class ValidatorManager {
    fun validateEmail(email: String): Boolean {
        return email.isNotBlank() && email.isNotEmpty() && email.contains("@") && email.contains(".")
    }
    fun validatePassword(password:String): Boolean{
        return password.length>=6
    }
}