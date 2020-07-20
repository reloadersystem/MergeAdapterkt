package com.reloader.mergeadapterkt.datasource

import com.reloader.mergeadapterkt.model.User

object DataSource {
    //crea un singleton

    val userList = mutableListOf(

        User("imagen", "Reloader"),
        User("imagen2", "Resembrink"),
        User("imagen3", "Developer")


    )
}