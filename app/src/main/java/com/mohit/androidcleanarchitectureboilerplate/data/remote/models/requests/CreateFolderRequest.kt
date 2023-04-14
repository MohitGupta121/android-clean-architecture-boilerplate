package com.mohit.androidcleanarchitectureboilerplate.data.remote.models.requests


import com.google.gson.annotations.SerializedName

data class CreateFolderRequest(
    @SerializedName("folderName")
    val folderName: String = "",
    @SerializedName("folderParentDirectory")
    val folderParentDirectory: String = ""
)