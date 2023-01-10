package com.example.primos;

public class ModelAleatorio {
    private static final double MAX_TIME = 0;
    private int n;
    public ModelAleatorio(){
        n=0;
    }
    public void generarAleatorio(int numero1, int numero2) throws InterruptedException {
        //Tarda en pedir la información
        esperarAleatorio();
        do {
            n = (int) (Math.random() * numero2) + numero1;
        }while (!esprimo(n));
    }
    public int getAleatorio(){
        return n;
    }

    private void esperarAleatorio() throws InterruptedException {
        Thread.sleep((long) (Math.random()*MAX_TIME));

    }
    private boolean esprimo(int n){
        boolean esPrimo=false;
        if (n == 0 || n == 1) return false;
  /*
          El número 4 es un caso especial, pues al dividirlo entre
          2 el resultado es 2, y el ciclo nunca se cumple, indicando que
          el 4 SÍ es primo, pero realmente NO lo es, así que si el número es 4
                        inmediatamente indicamos que no es primo (regresando 0)
          Nota: solo es para el 4, los demás funcionan bien
  */
        if (n == 4) return false;
        for (int x = 2; x <  n / 2; x++) {
            // Si es divisible por cualquiera de estos números, no
            // es primo
            if (n % x == 0) return false;
        }
        // Si no se pudo dividir por ninguno de los de arriba, sí es primo
        return true;
    }
}
