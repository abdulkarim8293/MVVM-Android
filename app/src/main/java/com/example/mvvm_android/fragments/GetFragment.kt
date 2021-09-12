package com.example.mvvm_android.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_android.AppConstant
import com.example.mvvm_android.R
import com.example.mvvm_android.adaptar.GetPokemonAdapter
import com.example.mvvm_android.network.ApiInterfaces
import com.example.mvvm_android.network.RetrofitClient
import com.example.mvvm_android.network.data.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GetFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var getPokemonAdapter: GetPokemonAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_get, container, false)

        getData()

        recyclerView = view.findViewById(R.id.getRecyclerView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this@GetFragment.context)


        return view
    }

    private fun getData() {
        val pokemon = RetrofitClient.getInstance(AppConstant.BASE_URL_1).create(ApiInterfaces::class.java).getPokemonResponse()

        pokemon.enqueue( object : Callback<PokemonResponse> {
            override fun onResponse(call: Call<PokemonResponse>?, response: Response<PokemonResponse>?) {

                if(response?.body() != null){
                    val pokemonResponse = response.body()
                    val list = ArrayList<PokemonResponse>()
                    list.add(pokemonResponse!!)
                    getPokemonAdapter = GetPokemonAdapter(list)
                    recyclerView.adapter = getPokemonAdapter
                    Toast.makeText(this@GetFragment.context,"${pokemonResponse?.name}", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(call: Call<PokemonResponse>?, t: Throwable?) {
                Log.i("TAG","${t!!.message}")

            }
        })
    }

}