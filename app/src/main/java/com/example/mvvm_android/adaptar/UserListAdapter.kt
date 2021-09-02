package com.example.mvvm_android.adaptar

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_android.OnItemClickListener
import com.example.mvvm_android.R
import com.example.mvvm_android.room_database.User

class UserListAdapter(private val userList: List<User>?,private val onItemClickListener: OnItemClickListener)  : RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val user = userList?.get(position)

        holder.userName.text = user?.name
        holder.phoneNumber.text = user?.phoneNumber

        holder.editUser.setOnClickListener {
            if (user != null) {
                onItemClickListener.onItemEdit(user)
            }
        }

        holder.deleteUser.setOnClickListener {
            if (user != null) {
                onItemClickListener.onItemDelete(user)
            }
        }

        Log.i("TAG","User List $user")

    }

    override fun getItemCount(): Int {
        return userList?.size!!
    }

    class MyViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val  userName:TextView = itemView.findViewById(R.id.userNameTv)
        val  phoneNumber:TextView = itemView.findViewById(R.id.phoneNumberTv)
        val  editUser:ImageView = itemView.findViewById(R.id.editUserIv)
        val  deleteUser:ImageView = itemView.findViewById(R.id.deleteUserIv)


    }

}