package com.mohit.androidcleanarchitectureboilerplate.ui.screens.main.searchResults

import com.mohit.androidcleanarchitectureboilerplate.data.local.models.StorageItem

data class SearchResultsScreenState(
    val items: List<StorageItem.File> = emptyList(),
    val isLoading: Boolean = false
)