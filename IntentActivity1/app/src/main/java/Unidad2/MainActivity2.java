package Unidad2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.intentactivity1.R;

public class MainActivity2 extends AppCompatActivity {
    TextView mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


            setContentView(R.layout.activity_main2);

            mensaje=findViewById(R.id.mensaje);
            Intent intento = getIntent();
            String tMensaje= intento.getStringExtra(MainActivity.preMensaje);
            mensaje.setText(tMensaje);
        }
    }