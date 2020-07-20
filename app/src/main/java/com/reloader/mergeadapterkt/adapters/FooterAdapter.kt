package com.reloader.mergeadapterkt.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reloader.mergeadapterkt.BaseViewHolder
import com.reloader.mergeadapterkt.R
import kotlinx.android.synthetic.main.footer.view.*

class FooterAdapter(private val context: Context, private val footerText: String) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return FooterViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.footer,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is FooterViewHolder -> holder.bind(footerText, position)
            else -> throw IllegalArgumentException("No se encontro el viewholder")
        }
    }

    inner class FooterViewHolder(itemView: View) : BaseViewHolder<String>(itemView) {
        override fun bind(item: String, position: Int) {

            itemView.footer_text.text = item
        }

    }
}