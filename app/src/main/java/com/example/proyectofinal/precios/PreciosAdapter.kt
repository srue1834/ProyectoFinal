package com.example.proyectofinal.precios

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.R
import com.example.proyectofinal.database.User
import kotlinx.android.synthetic.main.lista_precios.view.*
import android.content.Context as Context

class PreciosAdapter(private val context: Precios): RecyclerView.Adapter<PreciosAdapter.PreciosViewHolder>() {

    private var dataList = mutableListOf<User>()


    fun setData(data:MutableList<User>) {
        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreciosViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.lista_precios, parent, false)
        return PreciosViewHolder(view)
    }

    /*override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PreciosAdapter.PreciosViewHolder {
        val view = LayoutInflater.from((Context)).inflate(R.layout.lista_precios, parent, false)
        return PreciosViewHolder(view)


    }
*/
    override fun getItemCount(): Int {
        return if(dataList.size > 0) {
            dataList.size
        }else{
            0
        }
    }

    override fun onBindViewHolder(holder: PreciosAdapter.PreciosViewHolder, position: Int) {
        val user = dataList[position]
        holder.bindView(user)
    }

    inner class PreciosViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

        fun bindView(user:User){
            itemView.medicamento1.text = user.medicamento
            itemView.precio1.text = user.precio

        }

    }


}