package com.demo.example.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
class Users(
        @ColumnInfo(name = "mTitle") val mTitle: String
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}

//@Entity(tableName = "Users")
//data class Users(
//    val `data`: List<Data>,
//    val page: Int,
//    val per_page: Int,
//    val support: Support,
//    val total: Int,
//    val total_pages: Int
//)
//
//data class Support(
//        val text: String,
//        val url: String
//)
//
//data class Data(
//        val avatar: String,
//        val email: String,
//        val first_name: String,
//        val id: Int,
//        val last_name: String
//)