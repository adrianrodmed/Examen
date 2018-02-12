package com.basico;

public class Primos100 {
	public static void main(String[] args) {
        int ni = 1;/*Esto puedes cambiarlo para cambiar el intervalo (inicial)*/
        int nf = 100;/*Esto puedes cambiarlo para cambiar el intervalo (final)*/
        System.out.println("los números primos entre 0 y 100 son:");
        System.out.println (1);
        for (int i = 1; i <= (nf - ni + 1); i++ ) { /*Desde 1 a 100 en este caso*/
            int div = 0;
            int n = 0;
            for (int j = 1; j <= i; j++) {
                n = j;
                if ((i % j) == 0) {
                	div++;/*El divisor va aumentando*/
                	}
                if (div == 2){
                	break;
                	}
            }
            if (n == i && i != 1) {
            	System.out.println (i);
            }
        }
    }
}