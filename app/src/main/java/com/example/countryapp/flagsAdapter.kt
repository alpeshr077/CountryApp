package com.example.countryapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.countryapp.databinding.FlagsBinding
import java.util.ArrayList

class flagsAdapter(countryModel: ArrayList<CountryModel>,clicknow: ClickHere) : RecyclerView.Adapter<flagsAdapter.flagsholder>() {

    var list = countryModel
    lateinit var context: Context
    var Clicknow = clicknow

    class flagsholder(itemView: FlagsBinding) : ViewHolder(itemView.root) {
        var binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): flagsholder {
        context = parent.context
        var binding = FlagsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return flagsholder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: flagsholder, position: Int) {

        holder.binding.apply {
            list.get(position).apply {
                Glide.with(context).load(flags?.png).into(imgPhotos)
                txtName.text = name
                txtCapital.text = capital
                txtCode.text = callingCodes.toString()
                txtArea.text = area.toString()

                holder.itemView.setOnClickListener {
                    Clicknow.onclick(position)
                }

            }

        }

    }

}