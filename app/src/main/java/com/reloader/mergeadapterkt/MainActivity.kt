package com.reloader.mergeadapterkt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import com.reloader.mergeadapterkt.adapters.FooterAdapter
import com.reloader.mergeadapterkt.adapters.HeaderAdapter
import com.reloader.mergeadapterkt.adapters.MainAdapter
import com.reloader.mergeadapterkt.datasource.DataSource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)


        val headerAdapter = HeaderAdapter(this, "Reloader")
        val mainAdapter = MainAdapter(this, DataSource.userList)
        val footerAdapter = FooterAdapter(this, "Subscribete")

        val mergeAdapter = MergeAdapter(headerAdapter, mainAdapter, footerAdapter)
        recyclerView.adapter = mergeAdapter

        //mergeAdapter.addAdapter(adapter) // agregas  otro adapter en cualquier parte de la app
        //mergeAdapter.notifyDataSetChange()

        btn_change_titulo.setOnClickListener {
            headerAdapter.changeHeaderText("YouTube")
        }


    }

    fun comfigureRepeatViewTypes(
        headerAdapter: HeaderAdapter,
        mainAdapter: MainAdapter,
        footerAdapter: FooterAdapter
    ) {
        val builder = MergeAdapter.Config.Builder()
        builder.setStableIdMode(MergeAdapter.Config.StableIdMode.NO_STABLE_IDS)
        builder.setIsolateViewTypes(false)
        builder.build()

       // val mergeAdapter = MergeAdapter(builder, headerAdapter, mainAdapter, footerAdapter)
    }
}
