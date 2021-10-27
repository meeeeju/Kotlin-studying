//네비게이션 뷰 만드는 방법
//res/menu/nav_menu.xml
//layout 만들기  (이때 주의할 점: drawable로 바꾼후 constraint layout으로 변경하기)

package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btn_navi.setOnClickListener{
            layout_drawer.openDrawer(GravityCompat.START)  //start :left , END: right랑 같은 말
        }

        naviView.setNavigationItemSelectedListener (this)  //네비에기션 메뉴 아이템에 클릭 속성 부여
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId)  //switch 문
        {
            R.id.access-> Toast.makeText(applicationContext,"접근성",Toast.LENGTH_SHORT).show()
            R.id.email-> Toast.makeText(applicationContext,"이메일",Toast.LENGTH_SHORT).show()
            R.id.message-> Toast.makeText(applicationContext,"메세",Toast.LENGTH_SHORT).show()
        }
        layout_drawer.closeDrawers()  //네비게이션 뷰 닫기
        return false
    }

    override fun onBackPressed() {
        if (layout_drawer.isDrawerOpen(GravityCompat.START))
        {
            layout_drawer.closeDrawers()
        }
        else
        {
            super.onBackPressed()   //일반 백버튼 기능 실행
        }

    }


}