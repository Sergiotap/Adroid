package com.example.primos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AleatorioViewModel extends ViewModel {
    MutableLiveData<Integer> datosObserver;
    ModelAleatorio datos;
    public LiveData<Integer> getDatoAleatorio(){
        if(datosObserver==null){
            datosObserver=new MutableLiveData<Integer>();
            //generarAleatorio
            datos=new ModelAleatorio();
        }
        return datosObserver;
    }
    public void nuevoAleatorio(int numero1, int numero2){
        //Actividad Asíncrona
        new Thread(()->{
            try {
                //Petición a servidor remoto
                datos.generarAleatorio(numero1, numero2);
                //Informar de que ya llegó el dato
                datosObserver.postValue(datos.getAleatorio());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
