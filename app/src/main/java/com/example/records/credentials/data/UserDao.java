package com.example.records.credentials.data;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import model.User;

@androidx.room.Dao
public interface UserDao {

    @Insert
    void insertUser(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM users WHERE email_id = :email_id and password = :password")
    User login(String email_id, String password);

    @Query("SELECT * FROM users ORDER BY username ASC")
    LiveData<List<User>> getAllUsers();






}
