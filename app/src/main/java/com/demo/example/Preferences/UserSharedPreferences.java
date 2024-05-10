package com.demo.example.Preferences;

import android.content.Context;
import android.content.SharedPreferences;
import com.demo.example.model.UserResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserSharedPreferences {

    private static final String PREF_NAME = "my_pref";
    private static final String KEY_LIST = "Users_list";

    private SharedPreferences sharedPreferences;
    private Gson gson;

    public UserSharedPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public List<UserResponse> getUsersList() {
        String json = sharedPreferences.getString(KEY_LIST, null);
        Type type = new TypeToken<List<UserResponse>>() {
        }.getType();
        return gson.fromJson(json, type);
    }

    public void insertUsers(UserResponse mUsers) {
        List<UserResponse> mUsersList = getUsersList();
        if (mUsersList == null) {
            mUsersList = new ArrayList<>();
        }
        mUsersList.add(mUsers);
        saveUsersList(mUsersList);
    }

    public void updateUsers(UserResponse updatedUsers) {
        List<UserResponse> mUsersList = getUsersList();
        if (mUsersList != null) {
            for (int i = 0; i < mUsersList.size(); i++) {
                if (mUsersList.get(i).getId() == updatedUsers.getId()) {
                    mUsersList.set(i, updatedUsers);
                    saveUsersList(mUsersList);
                    return;
                }
            }
        }
    }

    public void deleteUsers(int mUsersId) {
        List<UserResponse> mUsersList = getUsersList();
        if (mUsersList != null) {
            for (int i = 0; i < mUsersList.size(); i++) {
                if (mUsersList.get(i).getId() == mUsersId) {
                    mUsersList.remove(i);
                    saveUsersList(mUsersList);
                    return;
                }
            }
        }
    }

    private void saveUsersList(List<UserResponse> mUsersList) {
        String json = gson.toJson(mUsersList);
        sharedPreferences.edit().putString(KEY_LIST, json).apply();
    }
}

