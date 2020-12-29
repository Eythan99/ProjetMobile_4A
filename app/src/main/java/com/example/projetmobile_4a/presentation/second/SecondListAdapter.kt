package com.example.projetmobile_4a.presentation.second

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetmobile_4a.data.remote.model.Weather

class SecondListAdapter(private val list: List<Weather>)
    : RecyclerView.Adapter<SecondViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SecondViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        val weather: Weather = list[position]
        holder.bind(weather)
    }

    override fun getItemCount(): Int = list.size

}