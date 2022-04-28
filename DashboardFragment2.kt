package com.example.splashscreen.fragments

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.splashscreen.R

class DashboardFragment2: Fragment() {
    private lateinit var home2: TextView

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dashboardfragment_two, parent, false)
        home2 = view.findViewById(R.id.home2)
        home2.text  = arguments?.getString("email")


        // Defines the xml file for the fragment
        return view
    }



}