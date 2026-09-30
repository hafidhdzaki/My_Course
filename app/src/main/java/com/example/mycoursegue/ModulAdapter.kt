package com.example.mycoursegue

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

// Adapter untuk mengelola dan menampilkan data daftar modul ke dalam RecyclerView
class ModulAdapter(
    private val listModul: List<ModulModel>, // Daftar data modul yang akan ditampilkan
    private val onModulClick: (ModulModel) -> Unit // Callback function (lambda) untuk menangani klik item
) : RecyclerView.Adapter<ModulAdapter.ModulViewHolder>() {

    // Inner class ViewHolder untuk menyimpan dan mengelola referensi komponen UI dari layout baris item (item_row.xml)
    class ModulViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardModul: CardView = view.findViewById(R.id.cardModul) // Mengambil komponen CardView pembungkus
        val tvNamaModul: TextView = view.findViewById(R.id.tvNamaModul) // Mengambil komponen TextView judul modul
    }

    // Dipanggil saat RecyclerView membutuhkan ViewHolder baru untuk memuat layout XML item (item_row.xml)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModulViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)
        return ModulViewHolder(view)
    }

    // Dipanggil untuk menghubungkan (binding) data dari daftar pada posisi tertentu ke komponen UI ViewHolder
    override fun onBindViewHolder(holder: ModulViewHolder, position: Int) {
        val modul = listModul[position]

        // Memasukkan teks modul
        holder.tvNamaModul.text = modul.namaModul

        // Menangani klik pada satu baris CardView
        holder.cardModul.setOnClickListener {
            onModulClick(modul)
        }
    }

    // Mengembalikan total jumlah item yang ada di dalam daftar data modul
    override fun getItemCount(): Int = listModul.size
}