package com.example.qurandemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(val context:Context, val list: List<RvModel>):RecyclerView.Adapter<RVAdapter.MyViewHolder>() {
    class MyViewHolder(v: View):RecyclerView.ViewHolder(v) {

        val tvVers:TextView = v.findViewById(R.id.tvVers)
        val tvVerseKey:TextView = v.findViewById(R.id.tvVerseKey)
        val txt:TextView = v.findViewById(R.id.txt)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvVers.text = context.resources.getString(R.string.total_verse, list.get(position).id)
        holder.tvVerseKey.text = context.resources.getString(R.string.sorah_verse, list.get(position).verse_key)
        holder.txt.text = list.get(position).text_imlaei
    }

    override fun getItemCount(): Int {
       return list.size
    }
}