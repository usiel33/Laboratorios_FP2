package Laboratorio1_Usiel;
//Laboratorio N° 1 - Ejercicio 2
//Autor: Usiel Suriel Quispe Puma
//colaboro :
//Tiempo : 20 min

import java.util.Scanner;

public class EJERCICIO2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String soldado1, soldado2, soldado3, soldado4, soldado5, ganador;
        int vida1, vida2, vida3, vida4, vida5, maxVida;
        System.out.println("Ingrese los nombres de los soldados : ");

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

        //vidas de los soldado
        vida1 = (int) (Math.random() * 5) + 1;
        vida2 = (int) (Math.random() * 5) + 1;
        vida3 = (int) (Math.random() * 5) + 1;
        vida4 = (int) (Math.random() * 5) + 1;
        vida5 = (int) (Math.random() * 5) + 1;

        maxVida = vida1;
        ganador = soldado1;

        if (vida2 > maxVida) {
            maxVida = vida2;
            ganador = soldado2;
        }
        if (vida3 > maxVida) {
            maxVida = vida3;
            ganador = soldado3;
        }
        if (vida4 > maxVida) {
            maxVida = vida4;
            ganador = soldado4;
        }
        if (vida5 > maxVida) {
            maxVida = vida5;
            ganador = soldado5;
        }

        //gana el que tenga mas vida
        System.out.println("\nGANADOR DE LA GUERRA : \n");
        System.out.println("Ganador : " + ganador + "\nNivel de vida : " + maxVida);

        System.out.println("\nSoldados con el mismo nivel de vida:");
        if (vida1 == maxVida&& !soldado1.equals(ganador)) {
            System.out.println(soldado1 + " con vida: " + vida1);
        }
        if (vida2 == maxVida && !soldado2.equals(ganador)) {
            System.out.println(soldado2 + " con vida: " + vida2);
        }
        if (vida3 == maxVida && !soldado3.equals(ganador)) {
            System.out.println(soldado3 + " con vida: " + vida3);
        }
        if (vida4 == maxVida && !soldado4.equals(ganador)) {
            System.out.println(soldado4 + " con vida: " + vida4);
        }
        if (vida5 == maxVida && !soldado5.equals(ganador)) {
            System.out.println(soldado5 + " con vida: " + vida5);
        }

    }

}
