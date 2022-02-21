package com.beyond.prac_20220221.Adapter

import android.Manifest
import android.content.Context
import android.content.Intent
import android.media.Rating
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.FragmentManager
import com.beyond.prac_20220221.DitailPizzaActivity
import com.beyond.prac_20220221.Model.StoreListModel
import com.beyond.prac_20220221.R
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermissionActivity.startActivity
import com.gun0912.tedpermission.normal.TedPermission

class StoreListAdpter(val mContext : Context, val resId : Int, val mList : ArrayList<StoreListModel>)
: ArrayAdapter<StoreListModel>(mContext, resId, mList) {
    //어레이 어댑터를 상속 받는데, 데이터의 형태는 LV_DataModel로 받아서 사용
    //ArrayAdapter는 ()지원 안함

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        return super.getView(position, convertView, parent)
        //getView -> xml과 dataclass조합, getView는 가장 간단한 형태로 굴러가게 하는 것, 여기에 layoutInflator 써서
        //우리가 만든 xml모양으로 뿌리자고 한 것
        //ConvertView라는 변수를 var 안에 옮겨닮고, 그 안이 null이면 xml inflate해서 채워라
        // 부가 정보에는 어떤 게 들어갈 수 있나?
        // 그 다음, row 변수를 만들어서 그 안에 temRow 옮겨 닮자
        // 만들어진 row가 최종 결과물이다.




        var temRow = convertView

        if (temRow == null){
            temRow = LayoutInflater.from(parent?.context).inflate(R.layout.item_list_of_store, null)
        }




        val row = temRow!!
        val data = mList[position]
        val data_int = position.toInt()
        val StoreImg = row.findViewById<ImageView>(R.id.img_store)
        val storeName=row.findViewById<TextView>(R.id.text_storeName)
        val callNum=row.findViewById<TextView>(R.id.num_storePhoneNum)
        val countingStar = row.findViewById<RatingBar>(R.id.rating_shuttingStar)
        val btn_call=row.findViewById<Button>(R.id.btn_call)
//        val T33=row.findViewById<TextView>(R.id.item3)


//        if(data_int == 0){Glide.with(context).load("https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg")
//            .into(StoreImg)
//        }
//        else if(data_int == 1){
//            Glide.with(context).load("http://mblogthumb2.phinf.naver.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800")
//                .into(StoreImg)
//
//        }
//        else if(data_int == 2){
//            Glide.with(context).load("https://pbs.twimg.com/profile_images/1098371010548555776/trCrCTDN_400x400.png")
//                .into(StoreImg)
//
//        }
//
//        else if(data_int == 3){
//            Glide.with(context).load("https://post-phinf.pstatic.net/MjAxODEyMDVfMzYg/MDAxNTQzOTYxOTA4NjM3.8gsStnhxz7eEc9zpt5nmSRZmI-Pzpl4NJvHYU-Dlgmcg.7Vpgk0lopJ5GoTav3CUDqmXi2-_67S5AXD0AGbbR6J4g.JPEG/IMG_1641.jpg?type=w1200")
//                .into(StoreImg)
//
//        }
//   else{
//       Glide.with(context).load(R.drawable.nyang).into(StoreImg)
//        }














        var II = position.toInt()

        storeName.text = data.name
        countingStar.rating = data.starPoint
        callNum.text = data.phoneNum.toString()
        StoreImg.setImageResource(R.drawable.nyang)

        Glide.with(mContext).load("${data.profile}").into(StoreImg)
        Log.d("힝",data.profile[position].toString())

        storeName?.setOnClickListener {
            val intent = Intent(context, DitailPizzaActivity::class.java)

            intent.putExtra("name", data.name)
            intent.putExtra("callNum", data.phoneNum)
            intent.putExtra("profile", data.profile)
            intent.putExtra("starlight", data.starPoint.toString())

            context.startActivity(intent)
        }

        btn_call?.setOnClickListener {
            Btn()
        }
//        Glide.with(mContext).load()


        return temRow!!
//        val inf = LayoutInflater.from(mContext)
    }
   private fun Btn (){
       val permissionlistener: PermissionListener = object : PermissionListener {
           override fun onPermissionGranted() {
               Toast.makeText(context, "전화 접근권한이 승인되어있습니다.", Toast.LENGTH_SHORT)
                   .show()

               val myUri = Uri.parse("tel:01026467422")
               val myIntent = Intent(Intent.ACTION_CALL, myUri)
               context.startActivity(myIntent)

           }


           override fun onPermissionDenied(deniedPermissions: List<String>) {
               Toast.makeText(
                   context,
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