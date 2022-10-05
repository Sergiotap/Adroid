package com.example.segundaactividad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declaraciones
    TextView salida;
    Button contador;
    Button resetear;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//Muestra la interfaz gráfica de la aplicación
        //Se referencian las declaraciones
        salida=findViewById(R.id.salida);
        contador=findViewById(R.id.contador);
        resetear=findViewById(R.id.resetear);
        contador.setOnClickListener(
                new View.OnClickListener() {
                    @Override

                    public void onClick(View view) {
                        salida.setText("El número es "+i);

                        i++;
                    }


                }
        );
        resetear.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        i=0;
                        salida.setText("El número es "+i);
                    }
                }
        );

    }



}