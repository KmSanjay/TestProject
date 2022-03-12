package com.example.testproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.R
import com.example.testproject.room.UserEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserListActivity : AppCompatActivity() {

    lateinit var userVM: UserListViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        init()
    }

    private fun init() {
        userVM = ViewModelProvider(this).get(UserListViewModel::class.java)

        userVM.getRecordsObserver().observe(this,Observer<List<UserEntity>>{
            this.renserUser(it)
            Log.d("TAG", "init: "+it)
        })

    }

    private fun renserUser(userList: List<UserEntity>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@UserListActivity)

            adapter = UserListAdapter(userList)

        }

    }
}