package com.example.records.credentials.data;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import model.User;

@androidx.room.Database(entities = {User.class}, version = 1, exportSchema = false)
public  abstract class UserDatabase extends RoomDatabase {

    private static final String dbName = "user";
    private static UserDatabase userDatabase;
    public abstract UserDao userDao();

    public static UserDatabase getUserDatabase(Context context){
        if(userDatabase == null){
            userDatabase = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, dbName)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return userDatabase;
    }




}
