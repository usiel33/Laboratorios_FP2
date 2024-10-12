
package Laboratorio1_Usiel;

//Laboratorio N° 1 - Ejercicio 1
//Autor: Usiel Suriel Quispe Puma
//colaboro :
//Tiempo : 20 min

import java.util.*;

public class EJERCICIO1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String soldado1, soldado2, soldado3, soldado4, soldado5;
        System.out.println("Ingrese los nombres de los soldados \n");

        System.out.print("Soldado 1: ");
        soldado1 = sc.next();
        System.out.print("Soldado 2: ");
        soldado2 = sc.next();
        System.out.print("Soldado 3: ");
        soldado3 = sc.next();
        System.out.print("Soldado 4: ");
        soldado4 = sc.next();
        System.out.print("Soldado 5: ");
        soldado5 = sc.next();

        //Mostrar datos de los soldados
        System.out.println("\nNOMBRES DE LOS SOLDADOS\n ");
        System.out.println("Nombre del soldado 1 : " + soldado1);
        System.out.println("Nombre del soldado 2 : " + soldado2);
        System.out.println("Nombre del soldado 3 : " + soldado3);
        System.out.println("Nombre del soldado 4 : " + soldado4);
        System.out.println("Nombre del soldado 5 : " + soldado5);
    }

}
