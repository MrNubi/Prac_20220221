package com.beyond.prac_20220221

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL
import android.widget.Toast
import com.beyond.prac_20220221.Adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission


class MainActivity : AppCompatActivity() {

    lateinit var mAdapter : ViewPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = mAdapter

        tab_layout1.setupWithViewPager(viewPager)




//        btn_call.setOnClickListener {
//            val permissionlistener: PermissionListener = object : PermissionListener {
//                override fun onPermissionGranted() {
//                    Toast.makeText(this@MainActivity, "전화 접근권한이 승인되어있습니다.", Toast.LENGTH_SHORT)
//                        .show()
//
//                    val myUri = Uri.parse("tel:01026467422")
//                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
//                    startActivity(myIntent)
//
//                }
//
//
//                override fun onPermissionDenied(deniedPermissions: List<String>) {
//                    Toast.makeText(
//                        this@MainActivity,
//                        "Permission Denied\n$deniedPermissions",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
//            TedPermission.create()
//                .setPermissionListener( permissionlistener )
//                .setPermissions( Manifest.permission.CALL_PHONE)  // android 에서 오는 Manifest 클래스 선택
//            .check()
//        }

        //Glide()



//        img_pet.setOnClickListener{
////            Glide.with(this).load(R.drawable.nyang).into(img_pet)
//            Glider(R.drawable.nyang, img_pet)
//
//        }



    }


}