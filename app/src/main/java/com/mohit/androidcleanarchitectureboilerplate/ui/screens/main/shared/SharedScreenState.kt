package com.mohit.androidcleanarchitectureboilerplate.ui.screens.main.shared

import com.mohit.androidcleanarchitectureboilerplate.data.local.models.StorageItem

data class SharedScreenState(
    val storageItems: List<StorageItem> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val isSharedByMeState: Boolean = false
)
