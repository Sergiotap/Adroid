package com.example.bases_app;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

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
    ImageView imagen;
    private Uri uriCapturada;
    ActivityResultLauncher<Intent> imgResult;
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
        imagen=findViewById(R.id.imagen);

        imgResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode()==RESULT_OK){
                        Intent data = result.getData();
                        uriCapturada = data.getData();
                        getContentResolver().takePersistableUriPermission(uriCapturada, Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        imagen.setImageURI(uriCapturada);
                    }
                }
        );
        imagen.setOnClickListener(v->{
            Intent i =new Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            i.putExtra(MediaStore.EXTRA_OUTPUT, uriCapturada);
            imgResult.launch(i);
        });
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
                    else {
                        Toast.makeText(getApplicationContext(), "No se ha encontrado el usuario", Toast.LENGTH_SHORT).show();
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
                    else {
                        Toast.makeText(getApplicationContext(), "No se ha encontrado el usuario", Toast.LENGTH_SHORT).show();
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