package com.amaa.fruitsapp

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView



class FruitsDetails : Fragment() {

    companion object {
        var itemname = "FruitName"
        var itemDescrption = "FruitDescription"
        var itemimage = "FruitImage"
        var itemimagepath = 0
        val SEARCH_PREFIX = "https://www.google.com/search?q="

    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fruits_details, container, false)
    }



    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        arguments?.let {
            itemname = it.getString(itemname).toString()
            itemDescrption = it.getString(itemDescrption).toString()
            itemimagepath = it.getInt(itemimage)

        }

        val fruit_name: TextView = itemView.findViewById(R.id.fruit_name)
        val fruit_Description: TextView = itemView.findViewById(R.id.fruit_Description)
        val fruit_image : ImageView = itemView.findViewById(R.id.fruit_image)
        val sharebutton : ImageButton = itemView.findViewById(R.id.sharebutton)
        val searchbutton : ImageButton = itemView.findViewById(R.id.searchbutton)

        fruit_name.text = itemname
        fruit_Description.text = itemDescrption
        fruit_image.setImageResource(itemimagepath)

        sharebutton.setOnClickListener {



        }

      searchbutton.setOnClickListener {

            val queryUrl: Uri = Uri.parse("${FruitsDetails.SEARCH_PREFIX}${itemname}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            context?.startActivity(intent)

        }

    }


}