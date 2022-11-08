package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class Datos extends AppCompatActivity {
    public String nombre;
    public String telefono;
    public static final int usuarios_iniciales = 0;
    static EditText eNombre;
    static EditText ePhone;
    ImageButton bImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        Intent intento = getIntent();
        eNombre=findViewById(R.id.eNombre);
        ePhone=findViewById(R.id.ePhone);
        bImage=findViewById(R.id.bImage);
        /*bImage.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }
        );*/
    }
    public static Datos generateUser(){
        Datos d = new Datos();
        d.nombre=String.valueOf(eNombre);
        d.telefono=String.valueOf(ePhone);
        return d;
    }
    public static Datos[] generateUsers(int n) {
        Datos[] datos = new Datos[n];
        for(int i = 0; i< n; i++){
            datos[i] = Datos.generateUser();
        }
        return datos;
    }
}