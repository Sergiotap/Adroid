package com.example.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    static EditText eNombre;
    static EditText ePhone;
    ImageButton bImage;
    Button bAñadir, bMostrar;
    TextView vista;
    base db;
    userDao usuarioDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        Intent intento = getIntent();
        eNombre = findViewById(R.id.eNombre);
        ePhone = findViewById(R.id.ePhone);
        bImage = findViewById(R.id.bImage);
        bAñadir = findViewById(R.id.bAgregar);
        bMostrar = findViewById(R.id.button);
        vista = findViewById(R.id.vVista);
        db = Room.databaseBuilder(getApplicationContext(),
                base.class, "usuarios").allowMainThreadQueries().build();
        usuarioDao = db.usuarioDao();
        bAñadir.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        user a = new user();
                        a.nombre = eNombre.getText().toString();
                        a.telefono = ePhone.getText().toString();
                        usuarioDao.insertAll(a);
                    }
                }
        );
        bMostrar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        List<user> usuarios = usuarioDao.getAll();
                        String sData = "";
                        for (user a : usuarios) {
                            sData += a.nombre + " - " + a.telefono + "\n";
                        }
                        vista.setText(sData);
                    }
                }
        );
    }
}
