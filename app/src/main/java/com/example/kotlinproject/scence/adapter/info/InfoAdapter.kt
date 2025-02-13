package com.example.kotlinproject.scence.adapter.info

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinproject.R
import com.example.kotlinproject.entity.CityResponse

class InfoAdapter(private val dataSet: List<CityResponse>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_info, parent, false)

        return InfoViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder.ViewHolder, position: Int) {
        when (holder) {
            is ItemViewHolder -> holder.bind(itemList[position].photo, itemList[position].name,
                itemList[position].actual_price, itemList[position].effective_period, itemList[position].stock)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        holder.city.text = dataSet[position].city
        holder.name.text = dataSet[position].name
        holder.address.text = dataSet[position].address
        holder.url.text = dataSet[position].url
        holder.opentime.text = dataSet[position].open_time
    }

    private inner class InfoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.txt_name)
        val city: TextView = view.findViewById(R.id.txt_city)
        val address: TextView = view.findViewById(R.id.txt_address)
        val url: TextView = view.findViewById(R.id.txt_url)
        val opentime: TextView = view.findViewById(R.id.txt_open_time)


    }
}