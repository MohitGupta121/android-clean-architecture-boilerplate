package com.mohit.androidcleanarchitectureboilerplate.data.remote.models.responses.folder

import com.mohit.androidcleanarchitectureboilerplate.data.remote.models.responses.OwnerDto
import com.google.gson.annotations.SerializedName

data class FolderDto(
    @SerializedName("folderName")
    val folderName: String = "",
    @SerializedName("folderOwner")
    val folderOwner: OwnerDto = OwnerDto(),
//    @SerializedName("folderParentDirectory")
//    val folderParentDirectory: ParentDirectory = ParentDirectory(),
    @SerializedName("_id")
    val id: String = "",
    @SerializedName("__v")
    val v: Int = 0
)
