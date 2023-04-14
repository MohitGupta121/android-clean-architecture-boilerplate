package com.mohit.androidcleanarchitectureboilerplate.data.remote.models.responses.file


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FileListResponse(
    @SerializedName("fileList")
    val fileList: List<FileDto> = listOf()
) : Serializable