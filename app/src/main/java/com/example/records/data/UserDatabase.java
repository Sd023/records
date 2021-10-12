package com.example.records.data;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.Courses;
import model.User;

@Database(entities = {Courses.class, User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    public static UserDatabase INSTANCE;
    public abstract UserDao userDao();
    private static final int NUMBER_OF_THREADS = 4;

    public static  final ExecutorService databaseWriterExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    public static UserDatabase getDatabase(final Context context){

        if(INSTANCE == null){
            synchronized (UserDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),UserDatabase.class,"Records_table")
                            .build();
                }
            }
        }
        return  INSTANCE;

    }


}
