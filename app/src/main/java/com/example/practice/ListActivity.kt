//list view 만들때 사용한 것
//user class 생성
//userAdapter 만들어주기 +list_item_user.xml
//activity_list.xml

package com.example.practice

import android.R.layout.simple_expandable_list_item_1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    var UserList= arrayListOf<User>(
        User(R.drawable.brain,"meeeeju","20","안녕하세용융"),
        User(R.drawable.brain,"ming_g","20","안녕하세용융"),
        User(R.drawable.brain,"툴라 ","20","메롱메"),
        User(R.drawable.brain,"주먹이 ","24","홀라홀라잉"),
        User(R.drawable.brain,"마이재재 ","21","반가워용? ")

    )
    override fun onCreate(savedInstanceState: Bundle?) {  //액티비티 실행 시작 시
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

//
//        //액티비티 정보 알려줌
//        var item= arrayOf("사과",'배',"딸기","키위","자두")
//        listView.adapter= ArrayAdapter(this, simple_expandable_list_item_1,item)  //listview는 항상 어뎁터가 있어야만 사용가능


        val Adapter=UserAdapter(this,UserList)
        listView.adapter=Adapter

        listView.onItemClickListener=AdapterView.OnItemClickListener { parent, view, position, id ->

            val selectItem=parent.getItemAtPosition(position) as User
            Toast.makeText(this,selectItem.name,Toast.LENGTH_SHORT).show()


        }


    }
}