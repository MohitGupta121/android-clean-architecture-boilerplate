package com.mohit.androidcleanarchitectureboilerplate.data.remote.models

import com.google.gson.annotations.SerializedName

data class MessageResponse(
    @SerializedName("message")
    val message: String = ""
)
