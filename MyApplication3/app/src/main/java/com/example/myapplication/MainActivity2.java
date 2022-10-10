package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    EditText tNombre;
    EditText tPhone;
    EditText tEmail;
    TextView vMostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tNombre=findViewById(R.id.tNombre);
        tPhone=findViewById(R.id.tPhone);
        tEmail=findViewById(R.id.tEmail);
        vMostrar=findViewById(R.id.vMostrar);
        TextView.OnEditorActionListener manejador = new TextView.OnEditorActionListener() {            @Override
            public boolean onEditorAction(TextView v, int actionID, KeyEvent keyEvent) {
                if (actionID== EditorInfo.IME_ACTION_GO){
                    vMostrar.setText(vMostrar.getText()+"\n"+tNombre.getText()+"\n"+tPhone.getText()+tEmail.getText());
                    vMostrar.setTextColor(Color.RED);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
                return false;
            }
        };
        tNombre.setOnEditorActionListener(manejador);
        tPhone.setOnEditorActionListener(manejador);
        tEmail.setOnEditorActionListener(manejador);

    }
}