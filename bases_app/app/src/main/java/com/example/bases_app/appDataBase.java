package com.example.bases_app;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {user.class}, version = 1)
public abstract class appDataBase extends RoomDatabase {
    public abstract userDAO usuarioDao();
}
