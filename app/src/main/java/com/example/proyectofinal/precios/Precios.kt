package com.example.proyectofinal.precios

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.proyectofinal.R
import com.example.proyectofinal.database.User
import com.example.proyectofinal.databinding.FragmentPreciosBinding
import kotlinx.android.synthetic.main.fragment_precios.*
import com.example.proyectofinal.precios.Precios as context

/**
 * A simple [Fragment] subclass.
 */
class Precios : Fragment() {
    companion object {

        fun newInstance(): context {
            return context()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            // columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }



    private lateinit var adapter: PreciosAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentPreciosBinding>(
            inflater,
            R.layout.fragment_precios, container, false)


        adapter = PreciosAdapter(this)

/*
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
*/
        val lista = mutableListOf<User>()
        lista.add(User("500","Lamictal" ))

        adapter.setData(lista)
        adapter.notifyDataSetChanged()



        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.navdrawer_menu, menu)

    }


}
