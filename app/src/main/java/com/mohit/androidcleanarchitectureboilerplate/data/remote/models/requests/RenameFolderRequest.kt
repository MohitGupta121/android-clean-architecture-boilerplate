package com.mohit.androidcleanarchitectureboilerplate.data.remote.models.requests

import com.google.gson.annotations.SerializedName

data class RenameFolderRequest(
    @SerializedName("folderId")
    val folderId: String,
    @SerializedName("newName")
    val newFileName: String,
)