package com.example.datomutable;

public class modelAleatorio {
    private static final double MAX_TIME = 1000;
    private int n;
    public modelAleatorio(){
        n=0;
    }
    public void generarAleatorio() throws InterruptedException {
        //Tarda en pedir la información
        esperarAleatorio();
        n=(int)(Math.random()*MAX_TIME);
    }
    public int getAleatorio(){
        return n;
    }

    private void esperarAleatorio() throws InterruptedException {
        Thread.sleep((long) (Math.random()*MAX_TIME));
    }
}
