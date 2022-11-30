package com.example.bases_app;


import static com.example.bases_app.userAdapter.requestPermissionLauncher;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.room.Room;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

public class MainActivity2 extends AppCompatActivity{
    Button bVolver/*, bEditar, bEliminar*/;
    appDataBase db;
    userDAO usuarioDao;
    TextView tNombre, tTelefono;
    //EditText tNuevoNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bVolver=findViewById(R.id.bVolver);
        //bEditar=findViewById(R.id.bEditar2);
        //bEliminar=findViewById(R.id.bEliminar2);
        tNombre=findViewById(R.id.vNombre);
        tTelefono=findViewById(R.id.tTelefono);
        //tNuevoNombre=findViewById(R.id.tNombreNuevo);
        db = Room.databaseBuilder(getApplicationContext(),
                appDataBase.class, "usuarios").allowMainThreadQueries().build();
        usuarioDao = db.usuarioDao();
        Intent intento = getIntent();
        tNombre.setText(intento.getStringExtra("nombre"));
        tTelefono.setText(intento.getStringExtra("telefono"));





        requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
            if (isGranted) {
                // Permission is granted. Continue the action or workflow in your
                // app.
                llamar();
            } else {
                // Explain to the user that the feature is unavailable because the
                // feature requires a permission that the user has denied. At the
                // same time, respect the user's decision. Don't link to system
                // settings in an effort to convince the user to change their
                // decision.
                Toast.makeText(this, "Necesitamos permiso para llamar", Toast.LENGTH_SHORT).show();
            }
        });
        /*bEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                List<user> usuarios = usuarioDao.getAll();
                for(user a : usuarios ){
                    if(tNombre.getText().toString().equals(a.nombre)){
                        usuarioDao.delete(a);
                    }
                }
            }
        });*/
        /*bEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tNuevoNombre.getVisibility()==View.INVISIBLE){
                    tNuevoNombre.setVisibility(View.VISIBLE);
                }
                else {
                    List<user> usuarios = usuarioDao.getAll();
                    for (user a : usuarios) {
                        if (tNombre.getText().toString().equals(a.nombre)) {
                            usuarioDao.delete(a);
                            user aNuevo = new user();
                            aNuevo.nombre = tNuevoNombre.getText().toString();
                            aNuevo.telefono = tTelefono.getText().toString();
                            usuarioDao.insertAll(aNuevo);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "No se ha encontrado el usuario", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });*/
        bVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intento2=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intento2);
            }
        });


    }
    private void llamar(){
        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
        //sin el tel: no entiende que es un numero de telefono
        phoneIntent.setData(Uri.parse("tel:+34"+tTelefono.getText().toString()));
        startActivity(phoneIntent);
    }

    public void llamadaClick(View v){
        if (ContextCompat.checkSelfPermission(
                MainActivity2.this, Manifest.permission.CALL_PHONE) ==
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
    }
}