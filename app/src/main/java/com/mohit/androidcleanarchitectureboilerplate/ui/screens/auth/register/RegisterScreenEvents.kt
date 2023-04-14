package com.mohit.androidcleanarchitectureboilerplate.ui.screens.auth.register

sealed class RegisterScreenEvents {
    data class ShowToast(val message: String) : RegisterScreenEvents()
    object NavigateToLoginScreen : RegisterScreenEvents()
    object NavigateToHomeScreen : RegisterScreenEvents()
}
