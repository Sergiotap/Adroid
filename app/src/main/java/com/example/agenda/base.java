package com.example.agenda;
import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {user.class}, version = 1)
public abstract class base extends RoomDatabase {
    public abstract userDao usuarioDao();
}

