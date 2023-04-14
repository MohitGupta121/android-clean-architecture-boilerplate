package com.mohit.androidcleanarchitectureboilerplate.ui.screens.main.shared

sealed class SharedScreenEvents {
    data class ShowToast(val message: String) : SharedScreenEvents()
}