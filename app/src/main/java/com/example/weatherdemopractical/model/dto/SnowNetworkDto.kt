package com.example.weatherdemopractical.model.dto

import com.google.gson.annotations.SerializedName

data class SnowNetworkDto(
    @SerializedName("3h")
    var threeHourlyVolume: Double
)
