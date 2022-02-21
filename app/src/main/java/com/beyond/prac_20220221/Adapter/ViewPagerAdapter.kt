package com.beyond.prac_20220221.Adapter

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.beyond.prac_20220221.Fragment.MypageFragment
import com.beyond.prac_20220221.Fragment.StoreFragment
import com.beyond.prac_20220221.R

class ViewPagerAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount() = 2

    override fun getPageTitle(position: Int): CharSequence? {
//        return super.getPageTitle(position)

        return when (position) {
            0 -> "Pizza"
            1 -> "My Page"
//            2 -> "3"
            else -> ""
            //이쪽이 리턴 덜적어서 효율적

        }
    }


    //함수의 결과를 바로 지정
    //코틀린 특이 문법

    override fun getItem(position: Int): Fragment {
//        when(position){
//            0 -> {return First_Fragment()}
//            1 -> {return BlankFragment()}
//            2 -> {return Blank2Fragment()}
//            else -> {return First_Fragment()}
//        }
        return when (position) {
            0 -> StoreFragment()
            1 -> MypageFragment()
//            2 -> Blank2Fragment()
            else -> StoreFragment()
            //이쪽이 리턴 덜적어서 효율적

        }
    }



    }



