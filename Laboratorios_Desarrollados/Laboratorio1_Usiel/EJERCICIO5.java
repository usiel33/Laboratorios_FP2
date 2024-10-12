package Laboratorio1_Usiel;
//Laboratorio N° 1 - Ejercicio 6
//Autor: Usiel Suriel Quispe Puma
//colaboro :
//Tiempo : 20 min

import java.util.*;

public class EJERCICIO5 {

    public static void main(String[] args) {
        Random random = new Random();
        int soldados1, soldados2;

        //Numero de soldados es aletario para cad ejercito
        soldados1 = random.nextInt(5) + 1;
        soldados2 = random.nextInt(5) + 1;

        //Arreglo de cad ejercito
        String ejercito2[] = new String[soldados1];
        String ejercito1[] = new String[soldados2];

        //inicializar nombre de los soldados de cada jercito
        inicializarSoldados(ejercito1, ejercito2);

        //mostrar datos de los doldados de cada ejercito
        mostrarDato(ejercito1, ejercito2);
        // mostrar el ejercito ganador
        mostrarGanador(ejercito1, ejercito2);
    }

    //metodo para inicializar los nombre de los solados
    public static void inicializarSoldados(String ejercito1[], String ejercito2[]) {
        for (int i = 0; i < ejercito1.length; i++) {
            ejercito1[i] = "soldado" + i;

        }
        for (int j = 0; j < ejercito2.length; j++) {
            ejercito2[j] = "soldado" + (j + 100);

        }

    }

    //metodo para mostrar datos de los soldados
    public static void mostrarDato(String ejercito1[], String ejercito2[]) {
        System.out.println("EJERCITO 1 \n");
        for (int i = 0; i < ejercito1.length; i++) {
            System.out.println((i + 1) + " : " + ejercito1[i]);

        }
        System.out.println("\nEJERCITO 2 \n");
        for (int j = 0; j < ejercito2.length; j++) {
            System.out.println((j + 1) + " : " + ejercito2[j]);

        }

    }

    // metodo para mostrar al ejercit ganador
    public static void mostrarGanador(String ejercito1[], String ejercito2[]) {
        if (ejercito1.length > ejercito2.length) {
            System.out.println("\nGANADOR : EJERCITO 1    \nCANTIDAD DE SOLDADOS : " + ejercito1.length);

        } else if (ejercito1.length < ejercito2.length) {
            System.out.println("\nGANADOR : EJERCITO 2    \nCANTIDAD DE SOLDADOS : " + ejercito2.length);
        } else {
            System.out.println("\nEMPATE !!");
        }

    }

}
