package com.example.countryapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.countryapp.databinding.FlagsBinding

class flagsAdapter:RecyclerView.Adapter<flagsAdapter.flagsholder>() {

    var flags =ArrayList<List<CountryModel>>()
    lateinit var context: Context
    class flagsholder(itemView: FlagsBinding) : ViewHolder(itemView.root) {
        var binding=itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): flagsholder {
        context=parent.context
        var binding = FlagsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return flagsholder(binding)
    }

    override fun getItemCount(): Int {
        return flags.size
    }

    override fun onBindViewHolder(holder: flagsholder, position: Int) {
        holder.binding.apply {
            flags.get(position).apply {
                Glide.with(context).load(flags).into(imgImage)
            }
        }

    }

    fun setflags(data: String?) {
        this.flags=data as ArrayList<List<CountryModel>>
    }
}