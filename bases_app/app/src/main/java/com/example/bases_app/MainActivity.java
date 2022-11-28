package com.example.bases_app;

import static com.example.bases_app.userAdapter.requestPermissionLauncher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
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
        //getSupportActionBar().hide();
        visualizar=findViewById(R.id.bMostrar);
        modificar=findViewById(R.id.bModificaciones);
        db = Room.databaseBuilder(getApplicationContext(),
                appDataBase.class, "usuarios").allowMainThreadQueries().build();
        usuarioDao = db.usuarioDao();
        visualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userlist.clear();
                List<user> usuarios = usuarioDao.getAll();
                for(user a : usuarios ){
                    //Toast.makeText(getApplicationContext(), a.nombre, Toast.LENGTH_LONG).show()
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
    //Estoy pensando cómo hacer esto para poder llamar a los teléfonos a partir de concederles permiso
    /*public static boolean conceder(boolean permiso){
        if (ContextCompat.checkSelfPermission(
                MainActivity.this, Manifest.permission.CALL_PHONE) ==
                PackageManager.PERMISSION_GRANTED) {
            // You can use the API that requires the permission.
            llamar();
        } else if (false) {
            // In an educational UI, explain to the user why your app requires this
            // permission for a specific feature to behave as expected, and what
            // features are disabled if it's declined. In this UI, include a
            // "cancel" or "no thanks" button that lets the user continue
            // using your app without granting the permission.

            // Mostrar UI Dialog para explicar al usuarios la necesidad del permiso
            // Vamos a usar la de por defecto de Android. Se ejecuta en el else

        } else {
            // You can directly ask for the permission.
            // The registered ActivityResultCallback gets the result of this request.
            requestPermissionLauncher.launch(Manifest.permission.CALL_PHONE);
        }
        return permiso;
    }
    public void llamar(){
        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
        phoneIntent.setData(Uri.parse((String) userAdapter.getDescripcion().getText()));
        startActivity(phoneIntent);
    }*/
}