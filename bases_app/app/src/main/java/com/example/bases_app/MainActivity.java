package com.example.bases_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Button add;
Button reload;
Button delete;
Button edit;
EditText nombre;
EditText phone;
EditText nuevoNombre;

appDataBase db;
userDAO usuarioDao;
private ArrayList<users>userlist;
RecyclerView recyclerUsuarios;
userAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userlist=new ArrayList<>();
        getSupportActionBar().hide();
        add=findViewById(R.id.bAdd);
        reload=findViewById(R.id.bReload);
        delete=findViewById(R.id.bEliminar);
        edit=findViewById(R.id.bEditar);
        nombre=findViewById(R.id.tNombre);
        phone=findViewById(R.id.tPhone);
        nuevoNombre=findViewById(R.id.tNuevoNombre);
        db = Room.databaseBuilder(getApplicationContext(),
                appDataBase.class, "usuarios").allowMainThreadQueries().build();
        usuarioDao = db.usuarioDao();
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<user> usuarios = usuarioDao.getAll();
                for(user a : usuarios ){
                    //Toast.makeText(getApplicationContext(), a.nombre, Toast.LENGTH_LONG).show();
                    //userlist.add(new users("Pepe","456");
                    userlist.add(new users(a.nombre, a.telefono));
                }
                createRecycler();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userlist.clear();
                user a = new user();
                a.nombre = nombre.getText().toString();
                a.telefono = phone.getText().toString();
                usuarioDao.insertAll(a);
            }
        });
        //Estos 2 métodos no funcionan correctamente por alguna razón.

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                userlist.clear();
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
                userlist.clear();
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
    public void createRecycler(){
        //Crea el ArrayList, obtiene el id del Recycler, obtiene el layout del dispositivo
        recyclerUsuarios =(RecyclerView) findViewById(R.id.rListaUsusarios);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
        recyclerUsuarios.setLayoutManager(layoutManager);
        //Se envia el ArrayList de las comidas
        adapter = new userAdapter(userlist);
        //Anades el adaptador al dispositivo
        recyclerUsuarios.setAdapter(adapter);
    }
}