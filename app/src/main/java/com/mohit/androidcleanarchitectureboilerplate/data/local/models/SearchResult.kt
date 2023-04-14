package com.mohit.androidcleanarchitectureboilerplate.data.local.models

import java.io.Serializable

data class SearchResult(
    val results: List<StorageItem.File>
) : Serializable
