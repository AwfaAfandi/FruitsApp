package com.amaa.fruitsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amaa.fruitsapp.adapter.FruitsAdapter
import com.amaa.fruitsapp.data.Datasource
import com.amaa.fruitsapp.databinding.ActivityMainBinding
import com.amaa.fruitsapp.databinding.FragmentFruitsListBinding


class FruitsList : Fragment() {
    private var _binding: FragmentFruitsListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    // Keeps track of which LayoutManager is in use for the [RecyclerView]




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Retrieve and inflate the layout for this fragment
        _binding = FragmentFruitsListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }



    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        recyclerView = binding.rvFruitsList

        val datset = Datasource().LoadItems()
        val adapter = FruitsAdapter(datset)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}