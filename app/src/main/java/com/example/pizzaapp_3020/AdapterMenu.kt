package com.example.pizzaapp_3020

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaapp_3020.response.food.FoodResponse
import com.squareup.picasso.Picasso

// AdapterMenu class yang menerima listMenu dari MenuModel
class AdapterMenu(private val listMenu: ArrayList<FoodResponse>) :
    RecyclerView.Adapter<AdapterMenu.ViewHolder>() {

    // ViewHolder untuk menampung view dari item menu
    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val imgFotoMenu: ImageView = v.findViewById(R.id.imageViewMenu)
        val textNamaMenu: TextView = v.findViewById(R.id.textViewNamaMenu)
        val textHargaMenu: TextView = v.findViewById(R.id.textViewHargaMenu)
        val btnAddMenu: TextView = v.findViewById(R.id.textViewAddMenu)
        val context: Context? = v.context

        fun bind(response: FoodResponse) {
            val name = "${response.food_name}"
            val price = "${response.price}"
            val picture = "${response.food_picture}"

            textNamaMenu.text = name
            textHargaMenu.text = price
            var url = "http://10.24.1.35:80/rest_api2990/gambar/" + picture
            Picasso.get().load(url).into(imgFotoMenu)
        }
    }

    // Menginflate layout item_menu untuk setiap item RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.card_layout_menu, parent, false)
        return ViewHolder(cellForRow)
    }

    // Mengikat data ke dalam ViewHolder berdasarkan posisi item
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listMenu[position])
    }

    // Mengembalikan jumlah item yang ada di dalam listMenu
    override fun getItemCount(): Int {
        return listMenu.size
    }
}
