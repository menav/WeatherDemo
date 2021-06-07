package com.example.weatherdemopractical.model.dto

import com.google.gson.annotations.SerializedName

data class WindNetworkDto(
    @SerializedName("speed")
    var speed: Double,
    @SerializedName("deg")
    var degree: Double
)
