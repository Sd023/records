package com.example.records.data;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import model.Courses;
import model.User;

@androidx.room.Dao
public interface UserDao {

    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM users WHERE email_id = :email_id and password = :password")
    User login(String email_id, String password);


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertCourses(Courses courses);

    @Delete
    void delete(Courses courses);

    @Query("DELETE FROM courses_table")
    void deleteAll();

    @Query("SELECT * FROM courses_table ORDER BY table_column_name ASC")
    LiveData<List<Courses>> getAllCourses();






}
