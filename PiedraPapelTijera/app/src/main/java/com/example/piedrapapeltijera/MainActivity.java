package com.example.piedrapapeltijera;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageButton bPiedra;
    ImageButton bPapel;
    ImageButton bTijeras;
    Button bReset;
    TextView tMaquina;
    TextView tResultado;
    TextView tContJugador;
    TextView tContMaquina;
    int datoMaquina;
    int contJugador=0;
    int contMaquina=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tMaquina=findViewById(R.id.tMaquina);
        tResultado=findViewById(R.id.tResultado);
        bPiedra=findViewById(R.id.bPiedra);
        bPapel=findViewById(R.id.bPapel);
        bTijeras=findViewById(R.id.bTijeras);
        tContJugador=findViewById(R.id.tContJugador);
        tContMaquina=findViewById(R.id.tContMaquina);
        bReset=findViewById(R.id.bReset);
        bPiedra.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        datoMaquina=(int) ((Math.random()*3)+1);
                        maquina();
                        switch (datoMaquina){
                            case 1:
                                tResultado.setText("Empate");
                                contJugador++;
                                contMaquina++;
                                break;
                            case 2:
                                tResultado.setText("Pierdes");
                                contMaquina++;
                                break;
                            case 3:
                                tResultado.setText("Ganas");
                                contJugador++;
                                break;
                        }
                        tContJugador.setText(String.valueOf(contJugador));
                        tContMaquina.setText(String.valueOf(contMaquina));
                    }
                }
        );
        bPapel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        datoMaquina=(int) ((Math.random()*3)+1);
                        maquina();
                        switch (datoMaquina){
                            case 1:
                                tResultado.setText("Ganas");
                                contJugador++;
                                break;
                            case 2:
                                tResultado.setText("Empate");
                                contJugador++;
                                contMaquina++;
                                break;
                            case 3:
                                tResultado.setText("Pierdes");
                                contMaquina++;
                                break;
                        }
                        tContJugador.setText(String.valueOf(contJugador));
                        tContMaquina.setText(String.valueOf(contMaquina));
                    }
                }
        );
        bTijeras.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        datoMaquina=(int) ((Math.random()*3)+1);
                        maquina();
                        switch (datoMaquina){
                            case 1:
                                tResultado.setText("Pierdes");
                                contMaquina++;
                                break;
                            case 2:
                                tResultado.setText("Ganas");
                                contJugador++;
                                break;
                            case 3:
                                tResultado.setText("Empate");
                                contJugador++;
                                contMaquina++;
                                break;
                        }
                        tContJugador.setText(String.valueOf(contJugador));
                        tContMaquina.setText(String.valueOf(contMaquina));
                    }
                }
        );
        bReset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        contJugador=0;
                        contMaquina=0;
                        tMaquina.setText("Se han reseteado las puntuaciones");
                        tResultado.setText("");
                        tContJugador.setText(String.valueOf(contJugador));
                        tContMaquina.setText(String.valueOf(contMaquina));
                    }
                }
        );

    }
    public void maquina(){
        switch (datoMaquina){
            case 1:
                tMaquina.setText("La maquina ha jugado piedra");
                break;
            case 2:
                tMaquina.setText("La maquina ha jugado papel");
                break;
            case 3:
                tMaquina.setText("La maquina ha jugado tijeras");
                break;
        }
    }
}