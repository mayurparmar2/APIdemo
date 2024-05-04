package com.demo.example.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.demo.example.model.Users

@Dao
interface UsersDao {

//    @Insert(onConflict = OnConflictStrategy.IGNORE)
    @Insert()
    suspend fun insert(mUsers: Users)

    @Delete
    suspend fun delete(mUsers: Users)

    @Query("Select * from Users")
    fun getAllUsers(): LiveData<List<Users>>

    @Update
    suspend fun update(mUsers: Users)

}