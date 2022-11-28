package com.example.bases_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class modUsuarios extends AppCompatActivity {
    Button add;
    Button editar;
    Button delete;
    Button ver;
    EditText nombre;
    EditText phone;
    EditText nuevoNombre;
    appDataBase db;
    userDAO usuarioDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mod_usuarios);
        //getSupportActionBar().hide();
        add=findViewById(R.id.bAdd);
        editar=findViewById(R.id.bEditar);
        delete=findViewById(R.id.bEliminar);
        ver=findViewById(R.id.bVisualizar);
        nombre=findViewById(R.id.tNombre);
        phone=findViewById(R.id.tPhone);
        nuevoNombre=findViewById(R.id.tNuevoNombre);
        db = Room.databaseBuilder(getApplicationContext(),
                appDataBase.class, "usuarios").allowMainThreadQueries().build();
        usuarioDao = db.usuarioDao();
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

        editar.setOnClickListener(new View.OnClickListener() {
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
        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzar();
            }
        });
    }
    public void lanzar(){
        finish();
        Intent intento2 = new Intent(this,MainActivity.class);
        startActivity(intento2);
    }
}