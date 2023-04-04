package br.senai.sp.jandira.loginapp.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.loginapp.model.User

@Database (entities = [User::class], version = 1)
abstract class TripDb : RoomDatabase() {

    abstract fun userDao (): UserDao

    companion object {
        private lateinit var instanceDB: TripDb

        fun getDatabese(context: Context): TripDb {

            if (!::instanceDB.isInitialized) {
                instanceDB = Room
                    .databaseBuilder(
                        context,
                        TripDb::class.java,
                        "db_trip"
                    ).allowMainThreadQueries().build()
            }
            return instanceDB

        }
    }


}