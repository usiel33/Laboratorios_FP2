package Laboratorio_03;
//Laboratorio N° 3- Ejercicio 1
//Autor: Usiel Suriel Quispe Puma

import java.util.*;

public class DemoBatalla {

    public static void main(String[] args) {
        Nave[] misNaves = new Nave[10];
        Nave[] navesRandom = new Nave[10];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt = 0;
        boolean est;

        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("\nNave " + (i + 1));
            System.out.print("Nombre: ");
            nomb = sc.next();
            System.out.print("Fila (1-10): ");
            fil = sc.nextInt();
            System.out.print("Columna (A-J): ");
            col = sc.next().toUpperCase();
            System.out.print("Estado(true - false) : ");
            est = sc.nextBoolean();
            System.out.print("Puntos: ");
            punt = sc.nextInt();
            //creamos obejto nave e ingresamos los valores 
            misNaves[i] = new Nave();

            misNaves[i].setNombre(nomb);
            misNaves[i].setFila(fil);
            misNaves[i].setColumna(col);
            misNaves[i].setEstado(est);
            misNaves[i].setPuntos(punt);
        }

        System.out.println("\n\tNAVES CREADAS");
        mostrarNaves(misNaves);
        System.out.println("-----------------------------\n");

        System.out.println("\tNAVES CON EL MISMO NOMBRE");
        System.out.print("Ingrese el nombre : ");
        nomb = sc.next();
        mostrarPorNombre(misNaves, nomb);//se agrego el argumento nombre
        System.out.println("-----------------------------\n");

        //mostramos los puntos de cada nave
        System.out.println("\tNAVES CON PUNTOS MENOR A PUNTOS INGRESADOS");
        System.out.print("Ingrese la cantidad de puntos de referencia : ");
        punt = sc.nextInt();
        mostrarPorPuntos(misNaves, punt);

        System.out.println("-----------------------------\n");
        System.out.println("\tNAVE(S)  CON MAYOR PUNTAJE");
        mostrarMayorPuntos(misNaves);

        //hacemos que se muestre los naves pero en orden desordenado por el cual
        System.out.println("-----------------------------\n");
        System.out.println("\tORDEN DE NAVES MODIFICADO");
        navesRandom = desordenarNaves(misNaves);//Nos devuelve otro arreglo, lo asignamos 
                                                //a otro arreglo 
        mostrarNaves(navesRandom); //Mostramos el nuevo arreglo
    }
//Método para mostrar todas las naves

    public static void mostrarNaves(Nave[] flota) { //listo
        for (int i = 0; i < flota.length; i++) {
            System.out.println("NAVE " + (i + 1));
            flota[i].mostrarDatos();
            System.out.println("");

        }

    }

//Método para mostrar todas las naves de un nombre que se pide por teclado
    public static void mostrarPorNombre(Nave[] flota, String nombre) {
        for (int i = 0; i < flota.length; i++) {
            if (flota[i] != null && flota[i].getNombre().equals(nombre)) {

                flota[i].mostrarDatos();
                System.out.println("");
            }

        }

    }

//Método para mostrar todas las naves con un número de puntos inferior o igual
//al número de puntos que se pide por teclado
    public static void mostrarPorPuntos(Nave[] flota, int puntos) {
        for (int i = 0; i < flota.length; i++) {
            if (flota[i].getPuntos() <= puntos) {
                flota[i].mostrarDatos();
                System.out.println("");
            }

        }

    }

//Método que devuelve la Nave con mayor número de Puntos
    public static void mostrarMayorPuntos(Nave[] flota) {
        int mayorPuntos = 0;
        int nave = 0;
        for (int i = 0; i < flota.length; i++) {
            if (flota[i].getPuntos() > mayorPuntos) {
                mayorPuntos = flota[i].getPuntos();
                nave = i;

            }

        }
        flota[nave].mostrarDatos();

    }

//Crear un método que devuelva un nuevo arreglo de objetos con todos los objetos
//previamente ingresados pero aleatoriamente desordenados
    public static Nave[] desordenarNaves(Nave[] flota) {
        Random random = new Random();
        Nave[] flotaRandom = new Nave[flota.length];

        //compiamos lo elementos del arreglo orgininal a otro arreglo
        for (int i = 0; i < flota.length; i++) {
            flotaRandom[i] = flota[i];
        }

        //Aplicamos el  algoritmo de Fisher-Yates para desordenar el arreglo
        for (int i = flotaRandom.length - 1; i > 0; i--) {
            int posAleatoria = random.nextInt(i + 1);
            Nave temp = flotaRandom[i];
            flotaRandom[i] = flotaRandom[posAleatoria];
            flotaRandom[posAleatoria] = temp;
        }

        return flotaRandom;
    }

}
