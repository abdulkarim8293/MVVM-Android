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
import com.example.mvvm_android.to_do_list.ToDoData

class ToDoListAdapter(private val todoList: List<ToDoData>?,private val onItemClickListener: OnItemClickListener)  : RecyclerView.Adapter<ToDoListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_to_do_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val toDoData = todoList?.get(position)

        holder.title.text = toDoData?.title
        holder.description.text = toDoData?.description
        holder.editToDo.setOnClickListener {
            toDoData?.let { it -> onItemClickListener.onItemEdit(it) }
        }
        holder.deleteToDo.setOnClickListener {
            toDoData?.let { it -> onItemClickListener.onItemDelete(it) }
        }


    }

    override fun getItemCount(): Int {
        return todoList?.size!!
    }

    class MyViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val  title:TextView = itemView.findViewById(R.id.titleTv)
        val  description:TextView = itemView.findViewById(R.id.descriptionTv)
        val  editToDo:ImageView = itemView.findViewById(R.id.editToDoIv)
        val  deleteToDo:ImageView = itemView.findViewById(R.id.deleteToDoIv)

    }

}