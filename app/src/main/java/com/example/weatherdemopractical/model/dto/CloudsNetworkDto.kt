package com.example.weatherdemopractical.model.dto

import com.google.gson.annotations.SerializedName

data class CloudsNetworkDto(
    @SerializedName("all")
    var all: Int
)