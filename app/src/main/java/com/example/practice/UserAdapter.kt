package com.example.practice

import android.content.Context   //액티비티 정보 담고있음
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

//adapter는 코드 연결할때 어뎁터
//list냄view는 반드시 어뎁터가 연결되어야하고 이 어뎁터가 연결되면 view를 만들어

class UserAdapter(val context: Context, val UserList:ArrayList<User>) :BaseAdapter() {
    override fun getCount(): Int {  //listview에서 view를 가지고 왔을때 어떡해 해줄꺼
        return UserList.size
    }

    override fun getItem(position: Int): Any {
        return UserList[position]
    }

    override fun getItemId(position: Int): Long {
      return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View=LayoutInflater.from(context).inflate(R.layout.list_item_user,null) //list view의 한 컬럼당 아이템은 이 레이아웃을 따fk
        val profile=view.findViewById<ImageView>(R.id.iv_listprofile)
        val name=view.findViewById<TextView>(R.id.tv_name)
        val age=view.findViewById<TextView>(R.id.tv_age)
        val greet=view.findViewById<TextView>(R.id.tv_greet)

        val user=UserList[position]

        profile.setImageResource(user.profile)
        name.text=user.name
        age.text=user.age
        greet.text=user.greet

        return view  //view를 반드시 return 해라...
    }
}