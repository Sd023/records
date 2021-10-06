package com.example.records.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.Courses;
import model.User;

@androidx.room.Database(entities = {Courses.class, User.class}, version = 1, exportSchema = false)
public  abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    private static UserDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

   public static UserDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (UserDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UserDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
   }
}
