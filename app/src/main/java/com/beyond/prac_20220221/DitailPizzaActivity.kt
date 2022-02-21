package com.beyond.prac_20220221

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class DitailPizzaActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ditail_pizza)

       var name12 = intent.getStringExtra("name").toString()
       var list12 = intent.getStringExtra("list").toString()

        Log.d("향","$name12")
        Log.d("향","$list12")



    }
}