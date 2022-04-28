package com.example.splashscreen.fragments

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.splashscreen.*

class DashboardFragment1: Fragment() {

    private lateinit var view1:View

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val  view = inflater.inflate(R.layout.dashboardfragment_one, parent, false)

        setupRecyclerView(view)
        // Defines the xml file for the fragment
        return view
    }

    fun setupRecyclerView(view:View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)

        //this creates a vertical layout Manager
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val data = ArrayList<Items>()

        //This loop will create 20 view containing
        // the image with the count of view
        for (i in 1..20){
            data.add(Items(R.drawable.ic_launcher_background, "item" +i))
        }

        //This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        //Setting the Adapter with the recyclerview
        recyclerView.adapter = adapter


    }


//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        //getting hte recyclerview by its id
//        val recyclerView = view1.findViewById<RecyclerView>(R.id.recyclerview)
//
        //this creates a vertical layout Manager
//        recyclerView.layoutManager = LinearLayoutManager(activity)
//
//        val data = ArrayList<ItemsViewModel>()
//
//        //This loop will create 20 view containing
//        // the image with the count of view
//        for (i in 1..20){
//            data.add(ItemsViewModel(R.drawable.ic_launcher_background, "${home1.text}" +i))
//        }
//
//        //This will pass the ArrayList to our Adapter
//        val adapter = CustomAdapter(data)
//
//        //Setting the Adapter with the recyclerview
//        recyclerView.adapter = adapter

//    }



}