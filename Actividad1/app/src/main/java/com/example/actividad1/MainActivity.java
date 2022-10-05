package com.example.actividad1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button bAceptar;
    EditText iNombre;
    TextView tMostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bAceptar=findViewById(R.id.bAceptar);
        iNombre=findViewById(R.id.iNombre);
        tMostrar=findViewById(R.id.tMostrar);
        bAceptar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tMostrar.setText(""+iNombre.getText());
                        iNombre.setText("");
                    }
                }
        );
    }
}