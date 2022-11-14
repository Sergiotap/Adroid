package com.example.bases_app;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import org.jetbrains.annotations.NotNull;
import java.util.UUID;
@Entity(tableName="usuarios")
public class user {
    @PrimaryKey
    @NotNull
    public String uid;
    @ColumnInfo(name = "nombre")
    public String nombre;
    @ColumnInfo(name = "telefono")
    public String telefono;
    public user(){
        uid=UUID.randomUUID().toString();
    }

}
