//
//텍스트 값을 잠깐 저장했을때 (푸시 알림 온 오프)
//서버에서 쓰는 중요한 디비 값은 사용되기 어려움

package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_shared.*

class SharedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {   //해당 액티비티가  처음 실행될때 한번 수행되는 곳 (초기화)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared)
        //todo: 저장된 데이터를 로드
        loadData()  //edit text 저장되어있던 값을 setText
    }

    private fun loadData() {
        var pref=getSharedPreferences("pref",0)
        //수정모드 필요없음
        et_hello.setText(pref.getString("name",""))  //1번째 인자에서 저장할 당시의 키 값을 적어주기 2번째는 키 값에 데이터가 존재하지 않을 경우 대체 값을 적어줌.

    }


    private fun saveData() {
        var pref=getSharedPreferences("pref",0)
        var edit=pref.edit() //수정모드
        edit.putString("name",et_hello.text.toString())  //1번째 인자에는 키 값을 2번째 인자에는 실제 담아둘 값을 저장하
        edit.apply()
    }

    override fun onDestroy() {  //해당 엑티비티 종료되는 시점이 다가올 때 호출
        super.onDestroy()

        saveData()  //editText값을 저장

    }
}


