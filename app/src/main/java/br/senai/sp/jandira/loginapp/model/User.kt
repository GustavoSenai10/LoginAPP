package br.senai.sp.jandira.loginapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_user")
data class User(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo("user_name")  var userName: String = "",
    var phone: String = "",
    var email: String = "",
    var password: String = "",
    @ColumnInfo("is_over_18") var isOver18: Boolean = false
)
