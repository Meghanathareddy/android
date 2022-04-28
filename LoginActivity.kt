package com.example.splashscreen


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.splashscreen.fragments.LoginFragment


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        addFragments()


    }





    private  fun addFragments(){
        // Begin the transaction
        // Begin the transaction
        val ft = supportFragmentManager.beginTransaction()
    // Replace the contents of the container with the new fragment
    // Replace the contents of the container with the new fragment
        ft.replace(R.id.placeholder, LoginFragment())
        // or ft.add(R.id.placeholder, LoginFragment())
    // Complete the changes added above
    // or  ft.add(R.id.placeholder, LoginFragment())
    // Complete the changes added above
        ft.commit()
    }


}