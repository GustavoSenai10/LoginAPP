package br.senai.sp.jandira.loginapp.dao

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.*
import br.senai.sp.jandira.loginapp.model.User

@Dao
interface UserDao {
    @Insert
    fun save(user: User): Long
    @Update
    fun  update(user: User): Int
    @Delete
    fun delete (user: User):Int
    @Query("SELECT * FROM tbl_user Where email = :email")
    fun findUserByEmail(email: String): User


}