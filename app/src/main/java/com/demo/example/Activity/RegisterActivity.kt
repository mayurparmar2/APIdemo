package com.demo.example.Activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.demo.example.Mvvm.UsersViewModel
import com.demo.example.R
import kotlinx.android.synthetic.main.activity_register.BtnSubmit
import kotlinx.android.synthetic.main.activity_register.etEmail
import kotlinx.android.synthetic.main.activity_register.etPassword
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    private lateinit var viewModal: UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        viewModal = ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(UsersViewModel::class.java)

        BtnSubmit.setOnClickListener {




            Log.e("TAG", "onCreate BtnSubmit: ")
            CoroutineScope(Dispatchers.IO).launch {
               val result =  viewModal.registerUsers(etEmail.text.toString(),etPassword.text.toString())
                Log.e("TAG", "onCreate result: $result")
            }
        }

    }
}