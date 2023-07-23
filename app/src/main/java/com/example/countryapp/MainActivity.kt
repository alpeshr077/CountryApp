package com.example.countryapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.countryapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    companion object {
        var CountryData = ArrayList<CountryModel>()
    }

    lateinit var binding: ActivityMainBinding
    private lateinit var adapter: flagsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        callApi()

    }

    private fun callApi() {

        var api = ApiClient.getApiClient()?.create(ApiInterface::class.java)
        api?.getcountrty()?.enqueue(object : Callback<List<CountryModel>> {
            override fun onResponse(
                call: Call<List<CountryModel>>,
                response: Response<List<CountryModel>>
            ) {

                CountryData = response.body() as ArrayList<CountryModel>

                if (response.isSuccessful) {

                    var clickNow = object : ClickHere{
                        override fun onclick(i: Int) {
                            var intent = Intent(this@MainActivity,Country_Details::class.java).putExtra("pos",i)
                            startActivity(intent)
                        }

                    }

                    binding.rcvflags.layoutManager = GridLayoutManager(this@MainActivity, 1)
                    binding.rcvflags.adapter = flagsAdapter(CountryData,clickNow)

                }

            }

            override fun onFailure(call: Call<List<CountryModel>>, t: Throwable) {

            }
        })

    }
}