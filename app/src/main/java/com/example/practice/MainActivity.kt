//버튼 누르면 화면 넘어가기 (화면 전환)
//activity_main + activity_sub

package com.example.practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var a :Int=0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        btn_a.setOnClickListener{
            //var  vs val
            //var: 변수 val: 자바에서는 final 값이 변경되지 못함
            //토스트 띄어주는 방법
            Toast.makeText(this@MainActivity,"버튼이 클릭되었습니다.",Toast.LENGTH_SHORT).show()
            iv_profile.setImageResource(R.drawable.androidgreen)


            //화면 전환 방법 + 메세지까지 넘겨주는 방법
            val intent= Intent(this,SubActivity::class.java)  //다음 화면으로이동하기 위한 인텐트 객체 생성
           intent.putExtra("msg",tv_textMsg.text.toString())  //hello world 라는 텍스트 값을 담은 뒤 msg라는 키로 잠궜다.
            startActivity(intent)  //intent에 저장되어 있는 액티비티 쪽으로 이동한다.
            //finish()  //자기 자신 액티비티를 파괴
        }
        btn_list.setOnClickListener{
            val intent2=Intent(this,ListActivity::class.java)
            startActivity(intent2)

        }
        a=2;

        if (a==2)
        {
            Log.d("if 문 ","ENTER")  //로그 안에는 무조권 문자값을 가져야함!!

        }
        else if (a==1){
            Log.d("else 문 ","ENTER")  //로그 안에는 무조권 문자값을 가져야함!!

        }
        Log.d("현재 a의 값 ",a.toString())  //로그 안에는 무조권 문자값을 가져야함!!
        Log.e("현재 a의 값 ",a.toString())  //로그 안에는 무조권 문자값을 가져야함!!


    }


}