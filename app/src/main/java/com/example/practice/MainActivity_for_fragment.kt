package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_for_fragment.*

class MainActivity_for_fragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_for_fragment)


        setFrag(0)

        btn_fragment1.setOnClickListener{
            setFrag(0)
        }
        btn_fragment2.setOnClickListener{
            setFrag(1)
        }
        btn_fragment3.setOnClickListener{
            setFrag(2)
        }
    }

    private fun setFrag(fragnum :Int) {   //메인 액티비티 속에서 화면들을 교체 해나가는 것! 메인액티비티가 사라지는 것이 아
        val ft= supportFragmentManager.beginTransaction()  //fragment교체 구현 가능함
        when (fragnum){
        0->{
            ft.replace(R.id.main_frag,Fragment1()).commit()
        }
        1->{
            ft.replace(R.id.main_frag,Fragment2()).commit()
        }
        2->{
            ft.replace(R.id.main_frag,Fragment3()).commit()
        }

        }

    }
}