package com.demo.example.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.demo.example.model.UserResponse


@Dao
interface UserResponseDao {

//    @Insert(onConflict = OnConflictStrategy.IGNORE)
    @Insert()
    suspend fun insert(mUsers: UserResponse)

    @Delete
    suspend fun delete(mUsers: UserResponse)

    @Query("Select * from UserResponse")
    fun getAllUsers(): LiveData<List<UserResponse>>

    @Update
    suspend fun update(mUsers: UserResponse)

}