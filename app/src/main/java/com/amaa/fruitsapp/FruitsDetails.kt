package com.amaa.fruitsapp

import android.annotation.SuppressLint
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
import java.io.File


class FruitsDetails : Fragment() {

    companion object {
        var nameid = "FruitName"
        var itemname = "FruitName"
        var descrptionid = "FruitDescription"
        var itemDescrption = "FruitDescription"
        var imageid = "FruitImage"
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




    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        arguments?.let {
            itemname = it.getString(nameid).toString()
            itemDescrption = it.getString(descrptionid).toString()
            itemimagepath = it.getInt(imageid)

        }

        var fruit_name: TextView = itemView.findViewById(R.id.fruit_name)
        var fruit_Description: TextView = itemView.findViewById(R.id.fruit_Description)
        var fruit_image : ImageView = itemView.findViewById(R.id.fruit_image)
        var sharebutton : ImageButton = itemView.findViewById(R.id.sharebutton)
        var searchbutton : ImageButton = itemView.findViewById(R.id.searchbutton)

        fruit_name.text = itemname
        fruit_Description.text = itemDescrption
        fruit_image.setImageResource(itemimagepath)


        sharebutton.setOnClickListener {



            val intent = Intent(Intent.ACTION_SEND).apply {

                type = "image/*"
                val bitmap = BitmapFactory.decodeResource(resources,itemimagepath )
                //  val path = MediaStore.Images.Media.insertImage(contentResolver , bitmap , "$id"  , "$id2" )
                val path = MediaStore.Images.Media.insertImage(requireContext().contentResolver , bitmap , "$itemname"  , "$itemDescrption" )
                val uri = Uri.parse(path)
                putExtra(Intent.EXTRA_STREAM , uri)
                putExtra(Intent.EXTRA_TEXT , "$itemname")




            }
            startActivity(intent)

        }

      searchbutton.setOnClickListener {

          var queryUrl: Uri = Uri.parse("${FruitsDetails.SEARCH_PREFIX}${itemname}")
          var intent = Intent(Intent.ACTION_VIEW, queryUrl)
            context?.startActivity(intent)

        }

    }


}