package com.example.datomutable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AleatorioViewModel extends ViewModel {
    MutableLiveData<Integer> datosObserver;
    modelAleatorio datos;
    public LiveData<Integer> getDatoAleatorio(){
        if(datosObserver==null){
            datosObserver=new MutableLiveData<Integer>();
            //generarAleatorio
            datos=new modelAleatorio();
        }
        return datosObserver;
    }
    public void nuevoAleatorio(){
        //Actividad Asíncrona
        new Thread(()->{
            try {
                //Petición a servidor remoto
                datos.generarAleatorio();
                //Informar de que ya llegó el dato
                datosObserver.postValue(datos.getAleatorio());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
