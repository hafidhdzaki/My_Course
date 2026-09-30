package com.example.mycoursegue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
// Konstanta kunci unik untuk mengambil data parameter dari Bundle
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MateriFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
// Fragment yang menampilkan daftar materi/modul pembelajaran menggunakan RecyclerView.
class MateriFragment : Fragment() {
    // TODO: Rename and change types of parameters
    // Variabel penampung parameter yang ditransfer ke Fragment
    private var param1: String? = null
    private var param2: String? = null

    // Siklus hidup awal Fragment saat dibuat (Membaca argumen/parameter jika ada)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    // Siklus hidup saat tampilan (UI) Fragment dirender
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // 1. Inflate layout fragment terlebih dahulu dan simpan ke variabel 'view'
        val view = inflater.inflate(R.layout.fragment_materi, container, false)

        // 2. Siapkan data list (panggil langsung ModulModel, hilangkan double ModulModel.ModulModel)
        val daftarMateri = listOf(
            ModulModel("[1] Modul 1: Install Android Studio"),
            ModulModel("[2] Modul 2: Linear Layout"),
            ModulModel("[3] Modul 3: Relative Layout"),
            ModulModel("[4] Modul 4: Constraint Layout"),
            ModulModel("[5] Modul 5: Activity & Intent"),
            ModulModel("[6] Modul 6: Spinner, Date Picker, Time Picker, Dialog")
        )

        // 3. Cari RecyclerView melalui variabel 'view' yang baru di-inflate
        val rvModul = view.findViewById<RecyclerView>(R.id.rvModul)

        // 4. Fragment WAJIB mengatur LayoutManager secara manual lewat kode jika belum diatur di XML
        rvModul.layoutManager = LinearLayoutManager(requireContext())

        // 5. Pasang adapter (gunakan requireContext() untuk menggantikan 'this' pada Toast)
        rvModul.adapter = ModulAdapter(daftarMateri) { modulYangDiklik ->
            Toast.makeText(requireContext(), "${modulYangDiklik.namaModul}", Toast.LENGTH_SHORT).show()
        }

        // 6. Kembalikan objek view ke sistem Android
        return view

        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_materi, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MateriFragment.
         */
        // TODO: Rename and change types and number of parameters
        // Factory method untuk membuat instance baru dari MateriFragment dengan parameter aman.
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MateriFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}