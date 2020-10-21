package com.example.memoriesproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.memoriesproject.database.MemoryEntity

class MemoryAdapter(val context:Context,val list: ArrayList<MemoryEntity>) :RecyclerView.Adapter<MemoryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view:View = LayoutInflater.from(context).inflate(R.layout.memory_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val memoryEntity = holder.itemView
        holder.title.text = list.get(position).title
        holder.breif.text = list.get(position).description
        holder.location.text = list.get(position).locationName
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title:TextView = itemView.findViewById(R.id.title_TV)
        val breif:TextView = itemView.findViewById(R.id.brief_TV)
        val location:TextView = itemView.findViewById(R.id.locationName)

    }
}