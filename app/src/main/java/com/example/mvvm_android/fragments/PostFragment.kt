package com.example.mvvm_android.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mvvm_android.AppConstant
import com.example.mvvm_android.R
import com.example.mvvm_android.network.ApiInterfaces
import com.example.mvvm_android.network.RetrofitClient
import com.example.mvvm_android.network.data.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_post, container, false)

        val uploadButton = view.findViewById<Button>(R.id.uploadPostBtn)

        uploadButton.setOnClickListener {

            val userId = view.findViewById<EditText>(R.id.userIdEt).text.toString()
            val id = view.findViewById<EditText>(R.id.postIddEt).text.toString()
            val postTitle = view.findViewById<EditText>(R.id.postTitleEt).text.toString()
            val postBody = view.findViewById<EditText>(R.id.postBodyEt).text.toString()

            if (userId.isEmpty() || id.isEmpty() || postTitle.isEmpty() || postBody.isEmpty()){
                Toast.makeText(this@PostFragment.context,"All field are required",Toast.LENGTH_SHORT).show()
            }else{
                postData(Post(userId.toInt(),id.toInt(),postTitle,postBody))
            }

        }

        return view
    }

    private fun postData(post: Post) {

        val call = RetrofitClient.getInstance(AppConstant.BASE_URL).create(ApiInterfaces::class.java).createPost(post)

        call.enqueue( object : Callback<Post> {
            override fun onResponse(call: Call<Post>?, response: Response<Post>) {

                if (response.isSuccessful){
                    Toast.makeText(this@PostFragment.context,"Success",Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(call: Call<Post>?, t: Throwable?) {
                Log.i("TAG","${t!!.message}")

            }
        })

    }

}