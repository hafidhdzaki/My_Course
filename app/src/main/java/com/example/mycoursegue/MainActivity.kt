package com.example.mycoursegue

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

// Activity utama aplikasi yang mengatur navigasi tab dan menu atas (ActionBar)
class MainActivity : AppCompatActivity() {

    // Variabel penampung objek ViewPager2 yang diinisialisasi secara bertahap (lateinit)
    private lateinit var viewPager: ViewPager2

    // Memuat berkas menu XML ke dalam ActionBar/Toolbar saat activity dibuat
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }

    // Menangani aksi/event ketika salah satu item pada menu atas diklik oleh pengguna
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            // Jika item 'Home' diklik, geser ViewPager2 ke halaman pertama (index 0)
            R.id.action_home -> {
                viewPager.setCurrentItem(0, true)
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                true
            }

            // Jika item 'Materi' diklik, geser ke halaman kedua (index 1) dengan animasi geser
            R.id.action_materi -> {
                viewPager.setCurrentItem(1, true) // true artinya perpindahan menggunakan animasi geser halus
                // Logika untuk melihat skor
                Toast.makeText(this, "Materi", Toast.LENGTH_SHORT).show()
                true
            }

            // Jika item 'Quiz' diklik, geser ke halaman ketiga (index 2)
            R.id.action_quiz -> {
                viewPager.setCurrentItem(2, true)
                Toast.makeText(this, "Quiz", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Objek konstanta berisi array ID string resource untuk nama-nama judul Tab
    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2,
            R.string.tab_text_3
        )
    }

    // Metode siklus hidup utama yang dipanggil saat Activity pertama kali dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menghubungkan activity dengan tata letak visualnya (activity_main.xml)
        setContentView(R.layout.activity_main)

        // Membuat objek adapter yang akan mengelola daftar Fragment di ViewPager
        val sectionsPagerAdapter = SectionPagerAdapter(this)

        // Mengambil view ViewPager2 dari layout dan memasang adapter-nya
        viewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter

        // Mengambil view TabLayout dari layout
        val tabs: TabLayout = findViewById(R.id.tab_layout)

        // Menghubungkan TabLayout dengan ViewPager2 agar judul tab sesuai dengan posisi halaman
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        // Menghilangkan efek bayangan (elevation) pada Action Bar agar tampilan menyatu dengan Tab
        supportActionBar?.elevation = 0f
    }
}