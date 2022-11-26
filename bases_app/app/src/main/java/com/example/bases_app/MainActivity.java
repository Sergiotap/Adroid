package com.example.bases_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
Button add;
Button reload;
Button delete;
Button edit;
EditText nombre;
EditText phone;
EditText nuevoNombre;
TextView vista;
appDataBase db;
userDAO usuarioDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=findViewById(R.id.bAdd);
        reload=findViewById(R.id.bReload);
        delete=findViewById(R.id.bEliminar);
        edit=findViewById(R.id.bEditar);
        nombre=findViewById(R.id.tNombre);
        phone=findViewById(R.id.tPhone);
        nuevoNombre=findViewById(R.id.tNuevoNombre);
        vista=findViewById(R.id.vVista);
        db = Room.databaseBuilder(getApplicationContext(),
                appDataBase.class, "usuarios").allowMainThreadQueries().build();
        usuarioDao = db.usuarioDao();
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<user> usuarios = usuarioDao.getAll();
                String sData = "";
                for(user a : usuarios ){
                    sData += a.nombre + " - " + a.telefono + "\n";
                }
                vista.setText(sData);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user a = new user();
                a.nombre = nombre.getText().toString();
                a.telefono = phone.getText().toString();
                usuarioDao.insertAll(a);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                List<user> usuarios = usuarioDao.getAll();
                for(user a : usuarios ){
                    if(nombre.getText().toString().equals(a.nombre)){
                        usuarioDao.delete(a);
                    }
                }
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<user> usuarios = usuarioDao.getAll();
                for (user a : usuarios){
                    if(nombre.getText().toString().equals(a.nombre)){
                        usuarioDao.delete(a);
                        user aNuevo = new user();
                        aNuevo.nombre = nuevoNombre.getText().toString();
                        aNuevo.telefono = phone.getText().toString();
                        usuarioDao.insertAll(aNuevo);
                    }
                }
            }
        });
    }
}