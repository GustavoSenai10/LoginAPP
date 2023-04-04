package br.senai.sp.jandira.loginapp.repository

import android.content.Context
import br.senai.sp.jandira.loginapp.dao.TripDb
import br.senai.sp.jandira.loginapp.model.User

class UserRepository(context: Context) {

    private val db = TripDb.getDatabese(context)

    fun save(user: User):Long{
        return db.userDao().save(user)
    }

}