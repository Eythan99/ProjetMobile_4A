package com.example.projetmobile_4a.data.remote

import com.example.projetmobile_4a.data.remote.model.Place
import com.example.projetmobile_4a.data.remote.model.RestWeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface WeatherApi {
    @GET
    fun getWeatherResponse(@Url url: String?): Call<RestWeatherResponse>

    @GET("/api/location/search/")
    fun getWoeidResponse(@Query("lattlong") gpscoordinate: String?): Call<List<Place>>
}