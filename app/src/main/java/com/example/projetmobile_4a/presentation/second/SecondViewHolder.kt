package com.example.projetmobile_4a.presentation.second

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetmobile_4a.R
import com.example.projetmobile_4a.data.remote.model.Weather
import com.squareup.picasso.Picasso

class SecondViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.row_layout, parent, false)) {
    private var temperature: TextView? = null
    private var meteo: TextView? = null
    private var titre: TextView? = null
    private var photo: ImageView? = null


    init {
        temperature = itemView.findViewById(R.id.temp)
        meteo = itemView.findViewById(R.id.weather)
        titre = itemView.findViewById(R.id.titre)
        photo = itemView.findViewById(R.id.icon)
    }

    fun bind(weather: Weather) {
        temperature?.text = weather.the_temp
        meteo?.text = weather.weather_state_name
        titre?.text = weather.title

        Picasso.get().load(
            "https://www.metaweather.com/static/img/weather/png/" + weather.weather_state_abbr + ".png"
        ).into(photo)
    }

}