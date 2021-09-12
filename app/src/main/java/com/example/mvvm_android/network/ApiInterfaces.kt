package com.example.mvvm_android.network

import com.example.mvvm_android.network.data.PokemonResponse
import com.example.mvvm_android.network.data.Post
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterfaces {

    @GET("pokemon/ditto")
    fun getPokemonResponse(): Call<PokemonResponse>

    @POST("posts")
    fun createPost(@Body post: Post):Call<Post>


}