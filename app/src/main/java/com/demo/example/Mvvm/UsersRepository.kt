package com.demo.example.Mvvm

import androidx.lifecycle.LiveData
import com.demo.example.Room.UsersDao
import com.demo.example.model.Users

class UsersRepository(private val mUsersDao: UsersDao) {

    val allUsers: LiveData<List<Users>> = mUsersDao.getAllUsers()

    suspend fun insertUsers(model: Users) {
        mUsersDao.insert(model)
    }

    suspend fun updateUsers(model: Users) {
        mUsersDao.update(model)
    }

    suspend fun deleteUsers(model: Users) {
        mUsersDao.delete(model)
    }
}