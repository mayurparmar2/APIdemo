package com.demo.example

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.demo.example.Mvvm.UsersViewModel
import com.demo.example.adapter.DataAdapter
import com.demo.example.model.UserResponse
import kotlinx.android.synthetic.main.activity_main.recycleView
import kotlinx.android.synthetic.main.activity_main.saveBtn

class MainActivity : AppCompatActivity() {
    lateinit var viewModal: UsersViewModel
    lateinit var dataAdapter: DataAdapter

    val userList = mutableListOf<UserResponse>()


    public override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.activity_main)

        viewModal = ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(UsersViewModel::class.java)



        dataAdapter = DataAdapter(application,userList, DataAdapter.OnUsersItemClick {
            startActivity(Intent(this@MainActivity, ViewActivity::class.java))
        })
        recycleView.adapter = dataAdapter

        saveBtn.setOnClickListener {
//            viewModal.addUsers(UserResponse(saveBtn.text.toString()))
        }
        viewModal.allUsers.observe(this, Observer {
            it?.let {
                dataAdapter.addItem(it)
            }
        })
    }
}