package com.reloader.mergeadapterkt.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reloader.mergeadapterkt.BaseViewHolder
import com.reloader.mergeadapterkt.R
import kotlinx.android.synthetic.main.header.view.*

class HeaderAdapter(private val context: Context, private var headerTitle: String) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return HeaderViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.header,
                parent,
                false
            )
        )

    }

    fun changeHeaderText(text: String){
        headerTitle= text
        notifyDataSetChanged()
    }



    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        // con el * se puede hacer distintos celdas diferente contenido

        when (holder) {
            is HeaderViewHolder -> holder.bind(headerTitle, position)
            else -> throw  IllegalArgumentException("No se encontro el viewholder")
        }
    }

    inner class HeaderViewHolder(itemView: View) : BaseViewHolder<String>(itemView) {
        override fun bind(item: String, position: Int) {

            itemView.header_text.text = item

        }
    }
}