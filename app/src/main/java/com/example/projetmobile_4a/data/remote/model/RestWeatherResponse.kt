package com.example.projetmobile_4a.data.remote.model

class RestWeatherResponse(
    var title: String,
    var sun_rise: String,
    var sun_set: String,
    var consolidated_weather: List<Consolidated_weather>
)