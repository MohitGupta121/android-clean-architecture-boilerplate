package com.mohit.androidcleanarchitectureboilerplate.ui.screens.splash

sealed class SplashScreenEvents {
    object NavigateToAuthScreen : SplashScreenEvents()
    object NavigateToHomeScreen : SplashScreenEvents()
}
