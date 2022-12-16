package com.amaa.fruitsapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.amaa.fruitsapp.FruitsDetails
import com.amaa.fruitsapp.R
import com.amaa.fruitsapp.model.Fruits

class FruitsAdapter(private val dataset: List<Fruits>) : RecyclerView.Adapter<FruitsAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {



        val item = dataset[position]
        holder.itemname.text = item.item_name
        holder.itemprice.text = item.item_price
        holder.itemdescription .text = item.item_description
        holder.itemimage.setImageResource(item.item_image)

        holder.itemcard.setOnClickListener {
            
            
            val context = holder.itemView.context
            val intent = Intent(context, FruitsDetails :: class.java)
            intent.putExtra("NAME" , item.item_name)
            intent.putExtra("DESCRIPTION" , item.item_description)
            intent.putExtra("IMAGE", item.item_image)
            context.startActivity(intent)


        }

    }



    override fun getItemCount() = dataset.size



    // TODO [2] Implement ViewHolder Class
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        val itemcard: CardView = view.findViewById(R.id.Item_card)
        val itemname: TextView = view.findViewById(R.id.item_name)
        val itemprice: TextView = view.findViewById(R.id.item_price)
        val itemdescription: TextView = view.findViewById(R.id.item_description)
        val itemimage : ImageView = view.findViewById(R.id.item_image)



    }// End ViewHolder


    // TODO [3] Implement Adapter override methods
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.fruit_item, parent, false)
        return ViewHolder(itemLayout)

    }






}