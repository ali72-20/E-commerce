package com.example.e_commerce.managers.login

sealed class LoginScreenActions {
}
class LoginAction: LoginScreenActions(){}
class GoToRegisterAction: LoginScreenActions(){}
