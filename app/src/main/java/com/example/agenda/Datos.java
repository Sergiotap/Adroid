package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;


public class Datos extends AppCompatActivity {
    public String nombre;
    public String telefono;
    public static int usuarios_iniciales = 0;
    private static ArrayList<String> nombresUsuarios = new ArrayList<String>(Arrays.asList(new String[]{"Pepe1","Pepe2","Pepe3","Pepe4","Pepe5"}));
    private static ArrayList<String> telfUsuarios = new ArrayList<String>(Arrays.asList(new String[]{"123456781","123456782","123456783","123456784","123456785"}));

    public static Datos generateUser(){
        Datos d = new Datos();
        d.nombre=nombresUsuarios.get(usuarios_iniciales);
        d.telefono=telfUsuarios.get(usuarios_iniciales);
        return d;
    }
    public static Datos[] generateUsers() {
        Datos[] datos = new Datos[nombresUsuarios.size()];
        for(int i = 0; i< nombresUsuarios.size(); i++){
            datos[i] = Datos.generateUser();
            usuarios_iniciales++;
        }
        return datos;
    }
}