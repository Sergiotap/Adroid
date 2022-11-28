package com.example.bases_app;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface userDAO {
    @Query("SELECT * FROM usuarios")
    List<user> getAll();
    @Query("SELECT * FROM usuarios WHERE uid IN (:userIds)")
    List<user> loadAllByIds(int[] userIds);
    @Query("SELECT * FROM usuarios WHERE nombre LIKE :nombre LIMIT 1")
    user findByName(String nombre);
    @Insert
    void insertAll(user... users);
    @Delete
    void delete(user user);
}
