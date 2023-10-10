package com.ecotales


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

interface OnClickListener {
    fun onClick(position: Int, model: WetlandEntity?)
    fun onClick(position: Int, model: LogEntity?)
}

class WetlandAdapter(private val items: List<WetlandEntity>, private val onItemClick: (WetlandEntity) -> Unit) : RecyclerView.Adapter<WetlandAdapter.ItemViewHolder>() {


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.title)
        val imageView: ImageView = itemView.findViewById(R.id.header_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.wetland_item_row, parent, false)
        return ItemViewHolder(view)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        print("item::::: "+item)
        holder.itemName.text = item.name
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
