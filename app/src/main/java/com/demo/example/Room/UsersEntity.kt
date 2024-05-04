package com.demo.example.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
public class UsersEntity(
        @ColumnInfo(name = "mTitle") val mTitle: String
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}