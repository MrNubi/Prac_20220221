package com.beyond.prac_20220221

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import kotlinx.android.synthetic.main.activity_ditail_pizza.*

class DitailPizzaActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ditail_pizza)

       var name12 = intent.getStringExtra("name").toString()
       var call12 = intent.getStringExtra("callNum").toString()
       var profile12 = intent.getStringExtra("profile").toString()
       var star12 = intent.getStringExtra("starlight").toString()


        Log.d("향","$name12\n$call12\n$profile12\n$star12")

        var hateFloat = star12.toFloat()
        Log.d("향","$hateFloat")

        text_changable_name.text = name12.toString()
        text_changable_phoneNum.text = call12.toString()
        var IM = findViewById<ImageView>(R.id.image_changable_image)
        Glide.with(this).load(profile12).into(IM)
        rating_changable_starPoint.rating = hateFloat
        btn_changable_callBtn.setOnClickListener {
            val permissionlistener: PermissionListener = object : PermissionListener {
                override fun onPermissionGranted() {
                    Toast.makeText(this@DitailPizzaActivity, "전화 접근권한이 승인되어있습니다.", Toast.LENGTH_SHORT)
                        .show()

                    val myUri = Uri.parse("tel:$call12")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)

                }


                override fun onPermissionDenied(deniedPermissions: List<String>) {
                    Toast.makeText(
                        this@DitailPizzaActivity,
                        "Permission Denied\n$deniedPermissions",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            TedPermission.create()
                .setPermissionListener( permissionlistener )
                .setPermissions( Manifest.permission.CALL_PHONE)  // android 에서 오는 Manifest 클래스 선택
                .check()

        }
        }







    }
