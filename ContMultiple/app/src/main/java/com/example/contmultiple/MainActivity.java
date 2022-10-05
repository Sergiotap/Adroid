package com.example.contmultiple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView contarTodo;
    TextView contarUno;
    TextView contarDos;
    TextView contarTres;
    TextView contarCuatro;
    Button resetearTodo;
    Button contadorUno;
    Button resetearUno;
    Button contadorDos;
    Button resetearDos;
    Button contadorTres;
    Button resetearTres;
    Button contadorCuatro;
    Button resetearCuatro;
    int i=0;
    int j=0;
    int k=0;
    int l=0;
    int m=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contarTodo=findViewById(R.id.contarTodo);
        contarUno=findViewById(R.id.contarUno);
        contarDos=findViewById(R.id.contarDos);
        contarTres=findViewById(R.id.contarTres);
        contarCuatro=findViewById(R.id.contarCuatro);
        resetearTodo=findViewById((R.id.resetearTodo));
        resetearUno=findViewById((R.id.resetearUno));
        resetearDos=findViewById((R.id.resetearDos));
        resetearTres=findViewById((R.id.resetearTres));
        resetearCuatro=findViewById((R.id.resetearCuatro));
        contadorUno=findViewById(R.id.contadorUno);
        contadorDos=findViewById((R.id.contadorDos));
        contadorTres=findViewById(R.id.contadorTres);
        contadorCuatro=findViewById((R.id.contadorCuatro));
        contadorUno.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        i++;
                        m+=1;
                        contarUno.setText(String.valueOf(i));
                        contarTodo.setText(String.valueOf(m));
                    }
                }
        );
        contadorDos.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        j++;
                        m+=1;
                        contarDos.setText(String.valueOf(j));
                        contarTodo.setText(String.valueOf(m));
                    }
                }
        );
        contadorTres.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        k++;
                        m+=1;
                        contarTres.setText(String.valueOf(k));
                        contarTodo.setText(String.valueOf(m));
                    }
                }
        );
        contadorCuatro.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        l++;
                        m+=1;
                        contarCuatro.setText(String.valueOf(l));
                        contarTodo.setText(String.valueOf(m));
                    }
                }
        );
        resetearTodo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        i=0;
                        j=0;
                        k=0;
                        l=0;
                        m=0;
                        contarUno.setText((String.valueOf(i)));
                        contarDos.setText((String.valueOf(j)));
                        contarTres.setText((String.valueOf(k)));
                        contarCuatro.setText((String.valueOf(l)));
                        contarTodo.setText((String.valueOf(m)));
                    }
                }
        );
        resetearUno.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        m-=i;
                        contarTodo.setText(String.valueOf(m));
                        i=0;
                       contarUno.setText((String.valueOf(i)));
                    }
                }
        );
        resetearDos.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        m-=j;
                        contarTodo.setText(String.valueOf(m));
                        j=0;
                        contarDos.setText((String.valueOf(j)));
                    }
                }
        );
        resetearTres.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        m-=k;
                        contarTodo.setText(String.valueOf(m));
                        k=0;
                        contarTres.setText((String.valueOf(k)));
                    }
                }
        );
        resetearCuatro.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        m-=l;
                        contarTodo.setText(String.valueOf(m));
                        l=0;
                        contarCuatro.setText((String.valueOf(l)));
                    }
                }
        );
    }
}