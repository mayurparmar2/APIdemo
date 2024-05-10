package com.demo.example.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.demo.example.Room.converter.SupportConverter
import com.demo.example.Room.converter.UserConverter
import com.demo.example.model.UserResponse

@Database(entities = arrayOf(UserResponse::class), version = 1)
@TypeConverters(SupportConverter::class,UserConverter::class)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getUsersDao(): UserResponseDao
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