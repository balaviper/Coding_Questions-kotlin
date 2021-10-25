package com.example.assesment4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView

data class ItemData(
    val name : String?,
    val time : String?,
    val price : String?
)

class HomeAdopter(
    private val context: Context,
    private val data : List<ItemData>
) : RecyclerView.Adapter<HomeHolder>(){
    private val _clkPos = MutableLiveData<Int>()
    val clkPos: LiveData<Int> = _clkPos

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        val root = LayoutInflater.from(context).inflate(
            R.layout.recycler_view,
            parent,
            false
        )

        return HomeHolder(root)
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        holder.name().text = data[position].name
        holder.price().text = data[position].price.toString()
        holder.time().text = data[position].time

        holder.reclView().setOnClickListener {
            _clkPos.value = position

        }

    }

    override fun getItemCount(): Int = data.size
}


class HomeHolder(
    private val view : View
): RecyclerView.ViewHolder(view){
    fun name() = itemView.findViewById<TextView>(R.id.itmName)
    fun price() = itemView.findViewById<TextView>(R.id.itmPrice)
    fun time() = itemView.findViewById<TextView>(R.id.itmTime)
    fun reclView() = itemView
}
