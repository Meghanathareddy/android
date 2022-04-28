package com.example.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //This is used to hide the status bar and make
        //the splash screen as a full screen activity
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN ,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )



        //We used the postDelayed(Runnable, time) method
        //to send a message with a delayed time
        Handler().postDelayed({
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
                              },2000)


    }
}