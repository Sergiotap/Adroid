package Unidad2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.intentactivity1.R;

public class MainActivity extends AppCompatActivity {
    static String preMensaje=".";
    Button bUT02;
    EditText tMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bUT02=findViewById(R.id.bUT02);
        tMensaje=findViewById(R.id.tMensaje);
        bUT02.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lanzar();
                    }
                }
        );
    }
    public void lanzar(){
        Intent intento = new Intent(this,MainActivity2.class);
        String mensaje= tMensaje.getText().toString();
        intento.putExtra(preMensaje,"Hola "+mensaje+"!!!!!!");
        startActivity(intento);
    }
}