package com.example.bases_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Button modificar;
Button visualizar;
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
        visualizar=findViewById(R.id.bMostrar);
        modificar=findViewById(R.id.bModificaciones);
        db = Room.databaseBuilder(getApplicationContext(),
                appDataBase.class, "usuarios").allowMainThreadQueries().build();
        usuarioDao = db.usuarioDao();
        visualizar.setOnClickListener(new View.OnClickListener() {
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
        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "funciono",Toast.LENGTH_SHORT).show();
                lanzar();
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
    public void lanzar(){
        Intent intento1 = new Intent(this,modUsuarios.class);
        startActivity(intento1);
    }
}