package com.demo.example.Mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.demo.example.Room.UserDatabase
import com.demo.example.model.Users
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersViewModel(application: Application) : AndroidViewModel(application) {

   private var mUsersrepository: UsersRepository
    val allUsers: LiveData<List<Users>>

    init {
        val dao = UserDatabase.getDatabase(application).getUsersDao()
        mUsersrepository = UsersRepository(dao)
        allUsers = mUsersrepository.allUsers
    }

    fun addUsers(mUsers: Users) {
        viewModelScope.launch(Dispatchers.IO) {
            mUsersrepository.insertUsers(mUsers)
        }
    }

    fun updateUsers(mUsers: Users) {
        viewModelScope.launch(Dispatchers.IO) {
            mUsersrepository.updateUsers(mUsers)
        }
    }

    fun deleteUsers(mUsers: Users) {
        viewModelScope.launch(Dispatchers.IO) {
            mUsersrepository.deleteUsers(mUsers)
        }
    }
}