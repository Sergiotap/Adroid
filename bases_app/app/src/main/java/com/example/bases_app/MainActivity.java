package com.example.bases_app;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
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
    appDataBase db;
    userDAO usuarioDao;
    private List<user> userlist;
    RecyclerView recyclerUsuarios;
    userAdapter adapter;
    private userAdapter.RecyclerViewClickListener listener;
    ActivityResultLauncher resultadoLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerUsuarios=(RecyclerView) findViewById(R.id.rListaUsusarios);
        userlist=new ArrayList<>();
        //getSupportActionBar().hide();
        modificar=findViewById(R.id.bModificar);
        createORM();
        createRecycler();
        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "funciono",Toast.LENGTH_SHORT).show();
                lanzar();
            }
        });
        resultadoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result ->{

                    //Codigo que va a recibir los Intents entrantes
                    userlist= usuarioDao.getAll();
                    adapter = new userAdapter(userlist,listener);
                    recyclerUsuarios.setAdapter(adapter);

                });

    }
    public void createRecycler(){

        //Llama al metodo  ClickListener
        setOnClickListener();

        adapter = new userAdapter(userlist,listener);

        //obtiene el layout del dispositivo
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this.getApplicationContext());
        recyclerUsuarios.setLayoutManager(LayoutManager);

        recyclerUsuarios.setItemAnimator(new DefaultItemAnimator());
        //Anades el adaptador al dispositivo
        recyclerUsuarios.setAdapter(adapter);
    }
    public void createORM(){
            //Se crea la base de datos
            db = Room.databaseBuilder(getApplicationContext(),
                    appDataBase.class, "usuarios").allowMainThreadQueries().build();

            //Extrae los datos de la bd para poder hacer querys
            usuarioDao = db.usuarioDao();

            //extr4e el contenido de la bd
            userlist= usuarioDao.getAll();


    }
    private void setOnClickListener() {
        listener= new userAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {

                //Crea un Intent que accede a la actividad que muestra el objeto
                Intent intent= new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("nombre",userlist.get(position).getNombre());
                intent.putExtra("descripcion",userlist.get(position).getTelefono());

                resultadoLauncher.launch(intent);
            }
        };}
    public void lanzar(){
        Intent intento1 = new Intent(this,modUsuarios.class);
        resultadoLauncher.launch(intento1);
    }
}