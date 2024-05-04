package com.demo.example.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.demo.example.model.Users

@Database(entities = arrayOf(Users::class), version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getUsersDao(): UsersDao

    companion object {
        private var INSTANCE: UserDatabase? = null
        fun getDatabase(context: Context): UserDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "UserDatabase"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}