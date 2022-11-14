package com.example.bases_app;

import androidx.appcompat.app.AppCompatActivity;
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
EditText nombre;
EditText phone;
TextView vista;
appDataBase db;
userDAO usuarioDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=findViewById(R.id.bAdd);
        reload=findViewById(R.id.bReload);
        nombre=findViewById(R.id.tNombre);
        phone=findViewById(R.id.tPhone);
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
    }
}