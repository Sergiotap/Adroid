package com.example.datomutable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
public class LiveDataEjemplo extends AppCompatActivity {
    private static final int MAX_VALUE = 100;
    Button btn;
    TextView label;
    MutableLiveData<Integer> datoObservable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.iButton);
        label=findViewById(R.id.iLabel);
        datoObservable=new MutableLiveData<Integer>(0);
        /*
           datoObservable.observe(this, new Observer<Integer>() {
               @Override
               public void onChanged(Integer integer) {
                    label.setText(integer.toString());
               }
           });

        */
        datoObservable.observe(this, dato-> {
            label.setText(String.valueOf(dato));
        });
        btn.setOnClickListener(view -> {
            datoObservable.postValue(new Integer((int)(Math.random()*MAX_VALUE)));
        });
    }
}