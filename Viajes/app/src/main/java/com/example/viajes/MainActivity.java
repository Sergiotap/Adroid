package com.example.viajes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText tFechaIda, tHoraIda, tFechaVuelta, tHoraVuelta, tNombre, tDirec, tDNI;
    Spinner spinner1,spinner2, spinner3;
    String tSpinner1, tSpinner2, tSpinner3;
    TextView FechaVuelta, HoraVuelta, CiudadSalida, CiudadLlegada;
    Button bConfirmar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner1=(Spinner) findViewById(R.id.tCiudadSalida);
            ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
            R.array.ciudades, android.R.layout.simple_spinner_item);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner1.setAdapter(adapter1);
        spinner2=(Spinner) findViewById(R.id.tCiudadLlegada);
            spinner2.setAdapter(adapter1);
        spinner3=(Spinner) findViewById(R.id.tipoViaje);
            ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
            R.array.tipoViaje, android.R.layout.simple_spinner_item);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner3.setAdapter(adapter2);
        tFechaIda=findViewById(R.id.tFechaIda);
        tHoraIda=findViewById(R.id.tHoraIda);
        tFechaVuelta=findViewById(R.id.tFechaVuelta);
        tHoraVuelta=findViewById(R.id.tHoraVuelta);
        tNombre=findViewById(R.id.tNombre);
        tDirec=findViewById(R.id.tDirec);
        tDNI=findViewById(R.id.tDNI);
        FechaVuelta=findViewById(R.id.FechaVuelta);
        HoraVuelta=findViewById(R.id.HoraVuelta);
        CiudadSalida=findViewById(R.id.CiudadSalida);
        CiudadLlegada=findViewById(R.id.CiudadLlegada);
        bConfirmar=findViewById(R.id.bConfirmar);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setOnItemSelectedListener(this);
        comprobarFormatos();
        bConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean validado=true;
                try {
                    validacion();
                } catch (ParseException x) {

                }

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
        if (adapterView.getId()==spinner1.getId()){
            tSpinner1=adapterView.getItemAtPosition(pos).toString();
        }
        else if(adapterView.getId()==spinner2.getId()){
            tSpinner2=adapterView.getItemAtPosition(pos).toString();
        }
        else{
            tSpinner3=adapterView.getItemAtPosition(pos).toString();
            comprobarViaje(tSpinner3);
        }
        comprobarCiudad(tSpinner1, tSpinner2);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void validacion() throws ParseException {
        Pattern PattDni = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
        Pattern PattFecha = Pattern.compile("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$");
        Pattern PattHora = Pattern.compile("[0-2]?[0-9]:[0-9]?[0-9]");
        Matcher matdni = PattDni.matcher(tDNI.getText());
        Matcher matFecha = PattFecha.matcher(tFechaIda.getText());
        Matcher matHora = PattHora.matcher(tHoraIda.getText());
        Pattern PattFechaV = Pattern.compile("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$");
        Pattern PattHoraV = Pattern.compile("[0-2][0-9]:[0-9][0-9]");
        Matcher matFechaV = PattFechaV.matcher(tFechaVuelta.getText());
        Matcher matHoraV = PattHoraV.matcher(tHoraVuelta.getText());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = sdf.parse("00/00/0000");
        Date fechaV = sdf.parse("00/00/0000");
        String EhoraT="",EFechaT="",EDniT="",ESpinnerT="",ESpinnerIdaT="";
        String EhoraTV=" - ",EFechaTV=" - ",ESpinnerVT=" - ";
        String ENombreT = String.valueOf(tNombre.getText());
        String EDireccionT = String.valueOf(tDirec.getText());
        validado=true;
    }
    public void comprobarViaje( String tSpinner3){
        if(!(tSpinner3.equalsIgnoreCase("Ida"))){
            FechaVuelta.setEnabled(true);
            HoraVuelta.setEnabled(true);
            tFechaVuelta.setEnabled(true);
            tHoraVuelta.setEnabled(true);
        }
        else{
            FechaVuelta.setEnabled(false);
            HoraVuelta.setEnabled(false);
            tFechaVuelta.setEnabled(false);
            tHoraVuelta.setEnabled(false);
        }
    }
    public void comprobarCiudad(String tSpinner1, String tSpinner2){
        if (tSpinner1.equalsIgnoreCase(tSpinner2)){
            CiudadSalida.setText("ERROR");
            CiudadLlegada.setText("ERROR");
        }
        else{
            CiudadSalida.setText("Ciudad de salida");
            CiudadLlegada.setText("Ciudad de llegada");
        }
    }
    public void comprobarFormatos(){

    }

}