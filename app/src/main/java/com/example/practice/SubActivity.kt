package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)


        //hasExtra intent값이 있다면?
        if( intent.hasExtra("msg")){
            tv_getMsg.text=intent.getStringExtra("msg")  //서브 액티비티의 존재하는 텍스트 뷰에다가 helloworldr가 적힘
        }
    }

}
