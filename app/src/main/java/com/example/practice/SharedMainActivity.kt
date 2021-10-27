//잠깐 저장하는 방법
//텍스트 값을 잠깐 저장했을때 (푸시 알림 온 오프)
//서버에서 쓰는 중요한 디비 값은 사용되기 어려움
//activity_shared.xml
//
//web view

package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_shared.*

class SharedMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {   //해당 액티비티가  처음 실행될때 한번 수행되는 곳 (초기화)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared)
        //todo: 저장된 데이터를 로드
        loadData()  //edit text 저장되어있던 값을 setText


        webView1.settings.javaScriptEnabled=true  //자바 스크립트 허용
//        웹 뷰에서 새 창이 뜨지 않도록 방지하도록 하는 구문
        webView1.webViewClient= WebViewClient()
        webView1.webChromeClient= WebChromeClient()

        webView1.loadUrl("http://www.naver.com/")
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

    override fun onBackPressed() {
        if(webView1.canGoBack())
        {//웹사이트에서 뒤로갈 페이지가 존재한다면
            webView1.goBack()  //웹사이트 뒤로가
        }
        else{
            super.onBackPressed()
        }

    }
}


