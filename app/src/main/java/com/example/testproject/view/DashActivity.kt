package com.example.testproject.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.testproject.R

class DashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash)

        val addUserBtn=findViewById<Button>(R.id.btn_add).setOnClickListener {
            val intent= Intent(this@DashActivity,MainActivity::class.java)
            startActivity(intent)

        }

        val listUserBtn=findViewById<Button>(R.id.btn_listuser).setOnClickListener {
            val intent= Intent(this@DashActivity,UserListActivity::class.java)
            startActivity(intent)

        }
    }
}