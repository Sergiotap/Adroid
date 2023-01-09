package com.example.datomutable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class AleatorioUID extends AppCompatActivity {
    Button btn;
    TextView label;
    LiveData<Integer> datoObservable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.iButton);
        label=findViewById(R.id.iLabel);
        AleatorioViewModel vm= new ViewModelProvider(this).get(AleatorioViewModel.class);
        datoObservable=vm.getDatoAleatorio();
        datoObservable.observe(this,(dato)->{
            label.setText(String.valueOf(dato));
        });
        btn.setOnClickListener((v)->{
            vm.nuevoAleatorio();
        });
    }
}