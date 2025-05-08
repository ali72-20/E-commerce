package com.example.e_commerce.managers.login

sealed interface LoginScreenActions
{
    data object LoginAction: LoginScreenActions
}

