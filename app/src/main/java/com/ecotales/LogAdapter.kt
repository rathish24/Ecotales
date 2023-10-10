package com.ecotales


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class LogAdapter(private val items: List<LogEntity>, private val onItemClick: (LogEntity) -> Unit) : RecyclerView.Adapter<LogAdapter.ItemViewHolder>() {


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val place: TextView = itemView.findViewById(R.id.place)
        val district: TextView = itemView.findViewById(R.id.district)
        val observation: TextView = itemView.findViewById(R.id.observation)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.log_item_row, parent, false)
        return ItemViewHolder(view)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        print("item::::: "+item)
        holder.place.text = item.logPlace
        holder.district.text = item.logDistrict
        holder.observation.text = item.logObservations
        holder.itemView.setOnClickListener {
            onItemClick(item)
        }



//        Glide.with(holder.imageView.getContext())
//            .load("https://static.toiimg.com/thumb/msid-74385994,imgsize-17700,width-400,resizemode-4/74385994.jpg")
//            .centerCrop()
//            .placeholder(R.drawable.placeholder)
//            .thumbnail(0.5f)
//            .into(holder.imageView);
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
