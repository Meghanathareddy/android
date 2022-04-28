package com.example.splashscreen


import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.splashscreen.fragments.DashboardFragment1
import com.example.splashscreen.fragments.DashboardFragment2
import com.example.splashscreen.fragments.DashboardFragments
import com.example.splashscreen.fragments.LoginFragment
import java.util.regex.Pattern


class DashBoardActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.logindashboardactivity)

        val email  = intent.getStringExtra(LoginFragment.BUNDLE_KEY_NAME)
        email?.let {
            addFragments(it)
        }







    }

    private  fun addFragments(email:String){
        val fragment  = DashboardFragments()
        val bundle = Bundle()
        bundle.putString("email",email+"\nDashboardFragments")
        fragment.arguments = bundle
        // Begin the transaction
        // Begin the transaction
        val ft = supportFragmentManager.beginTransaction()
        // Replace the contents of the container with the new fragment
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.placeholderForDashboardFragment, fragment)

        // or ft.add(R.id.placeholder, LoginFragment())
        // Complete the changes added above
        // or  ft.add(R.id.placeholder, LoginFragment())
        // Complete the changes added above
        ft.commit()
    }



}