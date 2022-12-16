package com.amaa.fruitsapp.data

import com.amaa.fruitsapp.R
import com.amaa.fruitsapp.model.Fruits

class Datasource {

    fun LoadItems() : List<Fruits> {

        return listOf(

            Fruits(R.drawable.banana , "Banana" , "A banana is a curved, yellow fruit with a thick skin and soft sweet flesh" , "7 SAR"),
            Fruits(R.drawable.red_apple_isolated_on_white_design_free_vector , "Apple" , "An apple is an edible fruit produced by an apple tree " , "10 SAR"),
            Fruits(R.drawable.images , "Orange" , " round usually sweet juicy fruit with a yellowish to reddish orange rind " , "5 SAR"),
            Fruits(R.drawable.fresh_pineapple_fruit_free_vector , "pineapple" , " edible tropical fruit somewhat resembling a pine cone" , "15 SAR")

        )


    }


}