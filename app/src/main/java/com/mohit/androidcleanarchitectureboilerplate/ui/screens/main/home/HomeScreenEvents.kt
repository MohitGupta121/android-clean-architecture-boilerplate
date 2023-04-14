package com.mohit.androidcleanarchitectureboilerplate.ui.screens.main.home

import com.mohit.androidcleanarchitectureboilerplate.data.local.models.StorageItem

sealed class HomeScreenEvents {
    data class ShowToast(val message: String) : HomeScreenEvents()
    data class NavigateToSearchResults(
        val title: String,
        val files: List<StorageItem.File>
    ) : HomeScreenEvents()
}