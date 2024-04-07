package com.example.dnevnadozaradovanja

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Context, var userList:List<MyDataItem>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var userId: TextView
        var title: TextView
        var imageView: ImageView
        var stranice: TextView

        init {
            userId = itemView.findViewById(R.id.userId)
            title = itemView.findViewById(R.id.title)
            imageView = itemView.findViewById(R.id.image_movie)
            stranice = itemView.findViewById(R.id.stranice)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(newData: List<MyDataItem>) {
        userList = newData
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userId.text = userList[position].naziv.toString()
        holder.title.text = "Cena: " + userList[position].cena.toString() + " dinara"
        holder.stranice.text =  "Stranice: " + userList[position].stranice.toString()
        Picasso
            .get()
            .load(userList[position].slika)
            .into(holder.imageView);
    }
}