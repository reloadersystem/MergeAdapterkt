package com.reloader.mergeadapterkt.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reloader.mergeadapterkt.BaseViewHolder
import com.reloader.mergeadapterkt.R
import com.reloader.mergeadapterkt.model.User
import kotlinx.android.synthetic.main.main_row.view.*

class MainAdapter(private val context: Context, private val userList: MutableList<User>) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MainViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.main_row,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
      return userList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {

        when (holder) {
            is MainViewHolder -> holder.bind(userList[position], position)
            else -> IllegalArgumentException("viewhoolder no encontrado")
        }
    }


    inner class MainViewHolder(itemView: View) : BaseViewHolder<User>(itemView) {
        override fun bind(item: User, position: Int) {

            itemView.username.text = item.nombre
            Glide.with(context).load(item.imagen).into(itemView.profile_image)

        }

    }

}
