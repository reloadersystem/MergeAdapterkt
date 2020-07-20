package com.reloader.mergeadapterkt

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T,position:Int)

    //clase Abstracta al llamarlo te implementa sus metodos
}