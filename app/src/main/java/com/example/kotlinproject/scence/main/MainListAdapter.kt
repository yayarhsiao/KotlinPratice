package com.example.kotlinproject.scence.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinproject.R
import com.example.kotlinproject.entity.CityResponse

class MainListAdapter(context: Context, var itemList: List<CityResponse>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.adapter_info, parent, false)

        return InfoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (itemList == null) 0 else itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is InfoViewHolder -> holder.bind(itemList[position].city, itemList[position].name,
                itemList[position].address, itemList[position].url, itemList[position].open_time)
        }
    }

    private inner class InfoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var infoCity: TextView = itemView.findViewById(R.id.txt_city)
        var infoName: TextView = itemView.findViewById(R.id.txt_name)
        var infoAdress: TextView = itemView.findViewById(R.id.txt_address)
        var infoUrl: TextView = itemView.findViewById(R.id.txt_url)
        var infoOpenTime: TextView = itemView.findViewById(R.id.txt_open_time)

        fun bind(city: String, name: String, adress: String, url: String, opentime: String) {
            infoCity.text = city
            infoName.text = name
            infoAdress.text = adress
            infoUrl.text = url
            infoOpenTime.text = opentime
        }
    }
}