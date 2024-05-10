package com.demo.example.Room.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.demo.example.model.User

class UserConverter {
    @TypeConverter
    fun fromString(value: String): List<User> {
        val listType = object : TypeToken<List<User>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<User>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}