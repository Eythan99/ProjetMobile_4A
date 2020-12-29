package com.example.projetmobile_4a.presentation.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetmobile_4a.R
import com.example.projetmobile_4a.data.remote.WeatherApi
import com.example.projetmobile_4a.data.remote.model.Place
import com.example.projetmobile_4a.data.remote.model.RestWeatherResponse
import com.example.projetmobile_4a.data.remote.model.Weather
import kotlinx.android.synthetic.main.activity_second.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.properties.Delegates

class SecondFragment : Fragment() {

    var listWeather: MutableList<Weather> = mutableListOf<Weather>()
    var listWoeid: MutableList<String> = mutableListOf<String>()
    var listWoeidIncrementation: Int = 1
    var listWoeidSize: Int = 1

    fun apiCall(){
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.metaweather.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service  = retrofit.create(WeatherApi::class.java)

        val woeidRequest = service.getWoeidResponse("48.75,2.69")

        woeidRequest.enqueue(object : Callback<List<Place>> {
            override fun onResponse(call: Call<List<Place>>, response: Response<List<Place>>) {
                if (response.isSuccessful && response.body() != null) {
                    val woeid: List<Place>? = response.body()
                    for (i in woeid!!.indices) {
                        listWoeid.add(woeid[i].woeid)
                    }
                    listWoeidIncrementation = 0
                    listWoeidSize = woeid.size
                    apiCall2(listWoeid.get(listWoeidIncrementation))
                } else {
                    error("KO")
                }
            }

            override fun onFailure(call: Call<List<Place>>, t: Throwable) {
                error("KO")
            }
        })
    }

    fun apiCall2(woeid: String){
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.metaweather.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service  = retrofit.create(WeatherApi::class.java)

        val woeidRequest = service.getWeatherResponse("https://www.metaweather.com/api/location/" + woeid)

        woeidRequest.enqueue(object : Callback<RestWeatherResponse> {
            override fun onResponse(
                call: Call<RestWeatherResponse>,
                response: Response<RestWeatherResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val currentWeather: RestWeatherResponse? = response.body()

                    val weather = Weather(
                        currentWeather!!.title,
                        currentWeather.sun_rise,
                        currentWeather.sun_set,
                        currentWeather.consolidated_weather.get(0).weather_state_name,
                        currentWeather.consolidated_weather.get(0).weather_state_abbr,
                        currentWeather.consolidated_weather.get(0).wind_direction_compass,
                        currentWeather.consolidated_weather.get(0).min_temp.substring(
                            0,
                            currentWeather.consolidated_weather.get(0).min_temp
                                .indexOf(".")
                        ),
                        currentWeather.consolidated_weather.get(0).max_temp.substring(
                            0,
                            currentWeather.consolidated_weather.get(0).max_temp
                                .indexOf(".")
                        ),
                        currentWeather.consolidated_weather.get(0).the_temp.substring(
                            0,
                            currentWeather.consolidated_weather.get(0).the_temp
                                .indexOf(".")
                        ),
                        currentWeather.consolidated_weather.get(0).wind_speed.substring(
                            0,
                            currentWeather.consolidated_weather.get(0).wind_speed
                                .indexOf(".")
                        ),
                        currentWeather.consolidated_weather.get(0).air_pressure.substring(
                            0,
                            currentWeather.consolidated_weather.get(0).air_pressure
                                .indexOf(".")
                        ),
                        currentWeather.consolidated_weather.get(0).humidity,
                        currentWeather.consolidated_weather.get(0).visibility.substring(
                            0,
                            currentWeather.consolidated_weather.get(0).visibility
                                .indexOf(".")
                        )
                    )

                    listWeather.add(weather)
                    listWoeidIncrementation++
                    if (listWoeidIncrementation == listWoeidSize) {
                        recyclerview.apply {
                            // set a LinearLayoutManager to handle Android
                            // RecyclerView behavior
                            layoutManager = LinearLayoutManager(activity)
                            // set the custom adapter to the RecyclerView
                            adapter = SecondListAdapter(listWeather)
                        }
                    } else {
                        apiCall2(listWoeid.get(listWoeidIncrementation))
                    }

                } else {
                    error("KO")
                }
            }

            override fun onFailure(call: Call<RestWeatherResponse>, t: Throwable) {
                error("KO")
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.activity_second, container, false)

    // populate the views now that the layout has been inflated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        apiCall()

    }

    companion object {
        fun newInstance(): SecondFragment = SecondFragment()
    }
}