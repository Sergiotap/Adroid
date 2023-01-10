package com.example.primos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2;
    TextView tNumAle;
    Button bPulsar;
    LiveData<Integer> datoObservable;
    int numero1, numero2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bPulsar=findViewById(R.id.bPulsar);
        tNumAle=findViewById(R.id.tNumAleatorio);
        num1=findViewById(R.id.tNum1);
        num2=findViewById(R.id.tNum2);
        AleatorioViewModel vm= new ViewModelProvider(this).get(AleatorioViewModel.class);
        datoObservable=vm.getDatoAleatorio();
        datoObservable.observe(this,(dato)->{
            tNumAle.setText(String.valueOf(dato));
        });
        bPulsar.setOnClickListener((v)->{
            //Toast.makeText(this,"Se ha insertado el numero "+num1.getText().toString()+"patata",Toast.LENGTH_SHORT).show();

            if(num1.getText().toString()==""){
                Toast.makeText(this,"Se ha de introducir un numero a la izquierda", Toast.LENGTH_SHORT).show();
            }
            else if(num2.getText().toString()==""){
                Toast.makeText(this,"Se ha de introducir un numero a la derecha", Toast.LENGTH_SHORT).show();
            }
            else{
                numero1=Integer.parseInt(num1.getText().toString());
                numero2=Integer.parseInt(num2.getText().toString());
                if(numero1>numero2){
                    Toast.makeText(this,"El número de la izquierda debe ser menor que el de la derecha", Toast.LENGTH_SHORT).show();
                }
                else{
                    tNumAle.setText("Cargando . . .");
                    vm.nuevoAleatorio(numero1, numero2);
                }
            }

        });
    }
}