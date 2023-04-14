package com.mohit.androidcleanarchitectureboilerplate.ui.screens.main.searchResults

sealed class SearchResultsScreenEvents {
    data class ShowToast(val message: String) : SearchResultsScreenEvents()
    object NavigateBack : SearchResultsScreenEvents()
}