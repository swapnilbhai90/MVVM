package com.fitrango.data.model.login

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: String
)