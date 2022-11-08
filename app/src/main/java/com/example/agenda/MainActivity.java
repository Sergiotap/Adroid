package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    static String preMensaje=".";
    RecyclerView lista;
    Button b1;
    DatosAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista=findViewById(R.id.lista);
        b1=findViewById(R.id.b1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
        lista.setLayoutManager(layoutManager);
        adapter = new DatosAdapter(Datos.generateUsers(Datos.usuarios_iniciales));
        lista.setAdapter(adapter);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.add(Datos.generateUsers(Datos.usuarios_iniciales));
                crearUsuario();
            }
        });
    }
    public void crearUsuario(){
        Log.d("LOG", "LLamada");
        Intent intento = new Intent(this,Datos.class);
        String mensaje= "inserte el ususario: ";
        intento.putExtra(preMensaje,"Hola "+mensaje+"!!!!!!");
        startActivity(intento);
    }
}