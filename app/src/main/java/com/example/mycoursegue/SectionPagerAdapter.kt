package com.example.mycoursegue

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

// Adapter khusus ViewPager2 yang bertugas mengelola dan menampilkan Fragment di setiap tab
class SectionPagerAdapter(activity: AppCompatActivity):
    FragmentStateAdapter(activity) {

    // Membuat dan mengembalikan instance Fragment yang sesuai berdasarkan posisi/indeks tab
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment() // Tab ke-1 (indeks 0) menampilkan HomeFragment
            1 -> MateriFragment() // Tab ke-2 (indeks 1) menampilkan MateriFragment
            2 -> QuizFragment() // Tab ke-3 (indeks 2) menampilkan QuizFragment
            else -> HomeFragment() // Pengaman jika ada indeks tak terduga
        }
    }

    // Mengembalikan jumlah total halaman/tab yang dikelola oleh ViewPager2
    override fun getItemCount(): Int {
        return 3
    }
}