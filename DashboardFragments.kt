package com.example.splashscreen.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.splashscreen.R


class DashboardFragments:Fragment() {
    private lateinit var home2:TextView
    private var email:String? = ""
    private lateinit var dashboardFragment1: Button
    private lateinit var dashboardFragment2: Button

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, parent, false)
        home2 = view.findViewById(R.id.home2)
        email = arguments?.getString("email")
        home2.text  = arguments?.getString("email")
        dashboardFragment1 = view.findViewById(R.id.dashboardFragment1)
        dashboardFragment2 = view.findViewById(R.id.dashboardFragment2)
        dashboardFragment1.setOnClickListener {
            email?.let {
                dashboardFragment1(it)
            }

        }
        dashboardFragment2.setOnClickListener {
            email?.let {
                dashboardFragment2(it)
            }
        }




        // Defines the xml file for the fragment
        return view
    }


    private  fun dashboardFragment1(email:String){
        val fragment  = DashboardFragment1()
        val bundle = Bundle()
        bundle.putString("email",email+"\nDashboardFragment1")
        fragment.arguments = bundle
        // Begin the transaction
        // Begin the transaction
        val ft = activity?.supportFragmentManager?.beginTransaction()
        ft?.replace(R.id.placeholderForDashboardFragment, fragment)
        ft?.commit()
    }

    private  fun dashboardFragment2(email:String){
        val fragment  = DashboardFragment2()
        val bundle = Bundle()
        bundle.putString("email",email+"\nDashboardFragment2")
        fragment.arguments = bundle
        // Begin the transaction
        // Begin the transaction
        val ft = activity?.supportFragmentManager?.beginTransaction()

        ft?.replace(R.id.placeholderForDashboardFragment, fragment)
        ft?.addToBackStack("secondFragment")

        ft?.commit()
    }




}