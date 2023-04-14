package com.mohit.androidcleanarchitectureboilerplate.data.remote.models.responses.file

import com.google.gson.annotations.SerializedName

data class UploadFileResponse(
    @SerializedName("file")
    val `file`: UploadedFile = UploadedFile()
)