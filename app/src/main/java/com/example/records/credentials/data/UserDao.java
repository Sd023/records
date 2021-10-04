package com.example.records.credentials.data;

import androidx.room.Insert;
import androidx.room.Query;

import model.User;

@androidx.room.Dao
public interface UserDao {

    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM users WHERE email_id = :email_id and password = :password")
    User login(String email_id, String password);





}
