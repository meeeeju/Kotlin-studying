package com.example.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class Fragment3: Fragment(){

    /*프래그먼트 실행시 */
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

        /*프래그먼트 xml이랑 연결해주기*/
        val view=inflater.inflate(R.layout.frag3,container,false)   //setcontentview랑 똑같음
        return view
    }
}