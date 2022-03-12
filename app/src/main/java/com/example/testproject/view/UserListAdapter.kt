package com.example.testproject.view

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import androidx.databinding.adapters.AdapterViewBindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.R
import com.example.testproject.room.UserEntity
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.userlist.view.*
import kotlinx.coroutines.awaitAll

class UserListAdapter(private val allUser: List<UserEntity>) :
    RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.userlist,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        if (allUser.size>0){
            holder.itemView.uname.setText(allUser.get(position).name)
            holder.itemView.uaddress.setText(allUser.get(position).address)
            holder.itemView.uphone.setText(allUser.get(position).phone)
            holder.itemView.uemail.setText(allUser.get(position).email)
        }
    }


    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun getItemCount(): Int {
        return allUser.size
    }
}


