package com.example.testproject.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.testproject.R
import com.example.testproject.repo.RoomRepository
import com.example.testproject.room.UserEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    lateinit var uname: String
    lateinit var uaddress: String
    lateinit var phone: String
    lateinit var email: String
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submitBtn = findViewById<Button>(R.id.btn_submit).setOnClickListener {
            val edName = findViewById<EditText>(R.id.ed_name)
            val edAddress = findViewById<EditText>(R.id.ed_address)
            val edPhone = findViewById<EditText>(R.id.ed_phone)
            val edEmail = findViewById<EditText>(R.id.ed_email)

            uname = edName.text.toString().trim()
            uaddress = edAddress.text.toString().trim()
            phone = edPhone.text.toString().trim()
            email = edEmail.text.toString().trim()


            if (uname.isEmpty() || uaddress.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else if (!isValidMobile(phone)) {

                Toast.makeText(this, "Please fill valid phone number ", Toast.LENGTH_SHORT).show()
            } else if (!isValidMail(email)) {

                Toast.makeText(this, "Please fill valid email id", Toast.LENGTH_SHORT).show()
            } else {

                val userEntity = UserEntity(0, uname, uaddress, phone, email)


                mainViewModel.insertRecords(userEntity)
                Toast.makeText(this, "Congratulations!!,Record Submitted Successfully", Toast.LENGTH_SHORT).show()

                //Once Data Saved in DB
                //Clear all field

                clearField()

                val intent = Intent(this@MainActivity, DashActivity::class.java)
                startActivity(intent)
            }
        }
        init()
    }

    private fun init() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private fun isValidMobile(phone: String): Boolean {
        return Patterns.PHONE.matcher(phone).matches()
    }

    private fun isValidMail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun clearField(){
        ed_name.text=null
        ed_address.text=null
        ed_phone.text=null
        ed_email.text=null
        ed_name.requestFocus()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}