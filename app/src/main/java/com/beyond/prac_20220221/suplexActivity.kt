package com.beyond.prac_20220221

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class suplexActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suplex)



        val H = Handler(Looper.getMainLooper())
        H.postDelayed({

            var K = Intent(this , MainActivity::class.java)
           startActivity(K)
            finish()
        },2500)


    }
}