package com.example.e_commerce.managers.register

sealed interface RegisterActions {
    data object NavigateToLoginAction : RegisterActions
}