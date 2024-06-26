package com.demo.example.Mvvm

import androidx.lifecycle.LiveData
import com.demo.example.Room.UserResponseDao
import com.demo.example.model.RegisterRequest
import com.demo.example.model.UserResponse
import com.demo.example.network.ApiService
import com.demo.example.network.RetrofitClient


class UsersRepository(private val mUsersDao: UserResponseDao) {

    val allUsers: LiveData<List<UserResponse>> = mUsersDao.getAllUsers()
    private val apiService: ApiService = RetrofitClient.createService(ApiService::class.java)


    suspend fun insertUsers(model: UserResponse) {
        mUsersDao.insert(model)
    }

    suspend fun updateUsers(model: UserResponse) {
        mUsersDao.update(model)
    }

    suspend fun deleteUsers(model: UserResponse) {
        mUsersDao.delete(model)
    }

    suspend fun registerUsers(email: String, pass: String): Boolean {
//        try {
        val requestBody = RegisterRequest(email, pass)
        val call = apiService.registerUser(requestBody,)
//        var result = false
//
//        apiService.registerUser(requestBody, object : Callback<RegisterResult?> {
//            override fun onResponse(call: Call<RegisterResult?>?, response: Response<RegisterResult?>?) {
//                response?.let {
//                    if(response.isSuccessful){
//                        result = true
//
//                    }
//                }
//            }
//            override fun onFailure(call: Call<RegisterResult?>?, t: Throwable?) {
//                result = false
//
//            }
//        })
//        return result
            val response = call?.execute()
            if(response?.isSuccessful == true){
                return true
            }else{
                return false
            }
//        }catch (e:Exception){
//
//            return false
//        }

    }
}