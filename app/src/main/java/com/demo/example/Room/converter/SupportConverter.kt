package com.demo.example.Room.converter
import androidx.room.TypeConverter
import com.demo.example.model.Support
import com.google.gson.Gson

class SupportConverter {
    @TypeConverter
    fun fromString(value: String): Support {
        return Gson().fromJson(value, Support::class.java)
    }

    @TypeConverter
    fun fromSupport(support: Support): String {
        return Gson().toJson(support)
    }
}
