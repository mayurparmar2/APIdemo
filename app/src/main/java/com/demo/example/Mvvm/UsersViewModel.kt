package com.demo.example.Mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.demo.example.Room.UserDatabase
import com.demo.example.model.UserResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class UsersViewModel(application: Application) : AndroidViewModel(application) {

   private var mUsersrepository: UsersRepository
    val allUsers: LiveData<List<UserResponse>>

    init {
        val dao = UserDatabase.getDatabase(application).getUsersDao()
        mUsersrepository = UsersRepository(dao)
        allUsers = mUsersrepository.allUsers
    }

    fun addUsers(mUsers: UserResponse) {
        viewModelScope.launch(Dispatchers.IO) {
            mUsersrepository.insertUsers(mUsers)
        }
    }

    fun updateUsers(mUsers: UserResponse) {
        viewModelScope.launch(Dispatchers.IO) {
            mUsersrepository.updateUsers(mUsers)
        }
    }

    fun deleteUsers(mUsers: UserResponse) {
        viewModelScope.launch(Dispatchers.IO) {
            mUsersrepository.deleteUsers(mUsers)
        }
    }
    suspend fun registerUsers(email:String, pass:String):Boolean {
      val job =   CoroutineScope(Dispatchers.IO).async {
          mUsersrepository.registerUsers(email,pass)
        }
         return job.await()
    }
}