package com.mohit.androidcleanarchitectureboilerplate.data.remote.models.responses.folder

import com.google.gson.annotations.SerializedName

data class GetFolderResponse(
    @SerializedName("folderList")
    val folderList: List<FolderDto> = listOf()
)
