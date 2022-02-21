package com.beyond.prac_20220221.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.beyond.prac_20220221.R
import kotlinx.android.synthetic.main.dialog_edit_nick.*
import kotlinx.android.synthetic.main.dialog_edit_nick.view.*
import kotlinx.android.synthetic.main.fragment_mypage.*


class MypageFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_mypage, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_nickChanger.setOnClickListener {


                val mDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_edit_nick, null)
                val mBuilder = AlertDialog.Builder(requireContext())
                    .setView(mDialogView)
                    .setTitle("닉네임을 설정해 주세요")
            val mAlterDialog = mBuilder.show()
            mAlterDialog.findViewById<Button>(R.id.btn_dialog_sellectnick)?.setOnClickListener {
                        Toast.makeText(requireActivity(), "닉네임이 설정됬습니다.", Toast.LENGTH_LONG).show()
                        var changed_nick = mDialogView.edit_dialog_nick.text.toString()
                        text_nickzone.text = changed_nick










            }





                }



            }






    }




