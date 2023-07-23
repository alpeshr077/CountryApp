package com.example.countryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.countryapp.databinding.ActivityCountryDetailsBinding

class Country_Details : AppCompatActivity() {

    lateinit var binding: ActivityCountryDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountryDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var pos = intent.getIntExtra("pos",0)
        var model = MainActivity.CountryData[pos]

        Glide.with(this).load(model.flags?.png).into(binding.imgFlags)
        binding.txtIndia.text = model.name
        binding.txtCapital2.text = model.capital
        binding.txtCountryCode.text = model.callingCodes.toString()
        binding.txtAllArea.text = model.area.toString()
        binding.txtLanguage.text = model.languages.toString()
        binding.txtPopulation.text = model.population.toString()
        binding.txtTimezone.text = model.timezones.toString()
        binding.txtCurrencies.text = model.currencies.toString()

    }
}