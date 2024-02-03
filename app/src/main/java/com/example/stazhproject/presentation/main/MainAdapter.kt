package com.example.stazhproject.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.stazhproject.databinding.CarItemsBinding
import com.example.stazhproject.model.Car


class MainAdapter(val carList: ArrayList<Car>, val onClick:(position:Int)-> Unit): RecyclerView.Adapter<MainAdapter.CarViewHolder>() {


    inner class CarViewHolder(private val binding: CarItemsBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(car: Car){
            with(binding){
                tvName.text = car.name
                tvYear.text = car.year
                Glide.with()
                    .load(car.image)
                    .into(ivCar)
            }

            itemView.setOnClickListener{
                itemView.setOnClickListener{
                    onClick(adapterPosition)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        return CarViewHolder(CarItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = carList.size

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bind(carList[position])
    }
}