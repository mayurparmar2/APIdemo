package com.demo.example;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.demo.example.Preferences.UserSharedPreferences;
import com.demo.example.adapter.DataAdapter;
import com.demo.example.databinding.ActivityMainBinding;
import com.demo.example.model.UserResponse;

import java.util.ArrayList;
import java.util.List;

public class MainActivityJava extends AppCompatActivity {
    private final String TAG = "MainActivityJava";

    ArrayList<UserResponse> users = new ArrayList<>();
    ActivityMainBinding binding;
    DataAdapter dataAdapter;
    UserSharedPreferences userPreferences;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userPreferences = new UserSharedPreferences(getApplicationContext());

        dataAdapter = new DataAdapter(getApplicationContext(), users, () -> {
            startActivity(new Intent(this, ViewActivity.class));
        });

        binding.recycleView.setAdapter(dataAdapter);
        loadData();



        binding.saveBtn.setOnClickListener(v -> {
//          userPreferences.insertUsers(new UserResponse(binding.noteTitleEdt.getText().toString()));
            loadData();

        });

    }

    private void loadData() {
        List<UserResponse> users = userPreferences.getUsersList();
        if (users != null) {
            dataAdapter.addItem(users);
        }
    }
}
