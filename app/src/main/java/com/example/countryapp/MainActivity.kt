package com.example.countryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.countryapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: flagsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = flagsAdapter()

        callApi()

    }

    private fun callApi() {

        var api = ApiClient.getApiClient()?.create(ApiInterface::class.java)
        api?.getcountrty()?.enqueue(object :Callback<List<CountryModel>>{
            override fun onResponse(
                call: Call<List<CountryModel>>,
                response: Response<List<CountryModel>>
            ) {
                if (response.isSuccessful){

                    var data = response.body()?.get(0)?.flags

                    adapter.setdata(data)

                    binding.rcvflags.layoutManager=GridLayoutManager(this@MainActivity,1)
                    binding.rcvflags.adapter=adapter

                }
            }

            override fun onFailure(call: Call<List<CountryModel>>, t: Throwable) {

            }


        })

    }
}