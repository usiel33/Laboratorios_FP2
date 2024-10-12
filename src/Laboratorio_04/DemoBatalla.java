package Laboratorio_04;

//Laboratorio Nº4 - Ejercicio 1
//Autor: Usiel Suriel Quispe Puma

import java.util.*;

public class DemoBatalla {

    public static void main(String[] args) {
        Nave[] misNaves = new Nave[8];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;

        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("Nave " + (i + 1));
            System.out.print("Nombre: ");
            nomb = sc.next();
            System.out.print("Fila :");
            fil = sc.nextInt();
            System.out.print("Columna: ");
            col = sc.next();
            System.out.print("Estado(true o false) : ");
            est = sc.nextBoolean();
            System.out.print("Puntos: ");
            punt = sc.nextInt();

            misNaves[i] = new Nave(); //Se crea un objeto Nave y se asigna su referencia a misNaves

            misNaves[i].setNombre(nomb);
            misNaves[i].setFila(fil);
            misNaves[i].setColumna(col);
            misNaves[i].setEstado(est);
            misNaves[i].setPuntos(punt);
            System.out.println("");
        }

        System.out.println("\n\tNaves creadas");
        mostrarNaves(misNaves);

        //Mostrar naves     que tenga el mismo nombre 
        System.out.println("\tNaves con el mismo nombre\n");
        System.out.print("Ingrese el nombre :");
        nomb = sc.next();
        mostrarPorNombre(misNaves, nomb);

        //Mostrar naves que tengan puntos inferiores a los puntos ingresados
        System.out.println("\n\tNaves que tienen puntos inferiores \n ");
        System.out.print("Ingrese la cantidad de puntos minimo: ");
        punt = sc.nextInt();
        mostrarPorPuntos(misNaves, punt);

        //Mostrar naves con el mayor puntaje
        System.out.println("\n\tNave con mayor numero de puntos\n ");
        mostrarMayorPuntos(misNaves);

        //leer un nombre
        //mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario
        System.out.println("\n\tBusqueda lineal ");
        System.out.print("\nIngrese el nombre de la nave que busca : ");
        nomb = sc.next();
        int pos = busquedaLinealNombre(misNaves, nomb);
        if (pos != -1) {
            misNaves[pos].mostrarDatos();
        } else {
            System.out.println("No econtrado");
        }

        System.out.println("\n\tOrdenamiento por la cantidad de puntos (Burbuja) ");
        ordenarPorPuntosBurbuja(misNaves);
        mostrarNaves(misNaves);

        System.out.println("\n\tOrdenamiento por nombre( Burbuja)");
        ordenarPorNombreBurbuja(misNaves);
        mostrarNaves(misNaves);

        //mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario
        System.out.println("\n\tBusqueda binaria por nombre ");
        System.out.print("Ingrese el nombre de la nave que busca : ");
        nomb = sc.next();
        pos = busquedaBinariaNombre(misNaves, nomb);
        if (pos != -1) {
            misNaves[pos].mostrarDatos();
        } else {
            System.out.println("No econtrado");
        }
        
        System.out.println("\n\tOrdenamiento por puntos( Seleccion)");
        ordenarPorPuntosSeleccion(misNaves);
        mostrarNaves(misNaves);

        System.out.println("\n\tOrdenamiento por nombres( Seleccion)");
        ordenarPorNombreSeleccion(misNaves);
        mostrarNaves(misNaves);

        System.out.println("\n\tOrdenamiento por puntos descendentemente( Insercion)");
        ordenarPorPuntosInsercion(misNaves);
        mostrarNaves(misNaves);

        System.out.println("\n\tOrdenamiento por nombre descendentemente (Insercion)");
        ordenarPorNombreInsercion(misNaves);
        mostrarNaves(misNaves);
    }

    //Método para mostrar todas las naves
    public static void mostrarNaves(Nave[] flota) {
        for (int i = 0; i < flota.length; i++) {
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
    //Método para buscar la primera nave con un nombre que se pidió por teclado

    public static int busquedaLinealNombre(Nave[] flota, String s) { 
        for (int i = 0; i < flota.length; i++) {
            if (flota[i] != null && flota[i].getNombre().equals(s)) {

                return i;
            }

        }
        return -1;

    }
    //Método que ordena por número de puntos de menor a mayor

    public static void ordenarPorPuntosBurbuja(Nave[] flota) {

        for (int i = 0; i < flota.length - 1; i++) {
            for (int j = 0; j < flota.length - 1 - i; j++) {
                if (flota[j].getPuntos() > flota[j + 1].getPuntos()) {
                    Nave temp = flota[j];
                    flota[j] = flota[j + 1];
                    flota[j + 1] = temp;
                }
            }
        }

    }

    //Método que ordena por nombre de A a Z
    public static void ordenarPorNombreBurbuja(Nave[] flota) {
        for (int i = 0; i < flota.length; i++) {
            for (int j = 0; j < flota.length - 1 - i; j++) {
                if (flota[j].getNombre().compareTo(flota[j + 1].getNombre()) > 0) {
                    Nave temp;
                    temp = flota[j];
                    flota[j] = flota[j + 1];
                    flota[j + 1] = temp;

                }

            }

        }

    }
    //Método para buscar la primera nave con un nombre que se pidió por teclado

    public static int busquedaBinariaNombre(Nave[] flota, String s) {
        int baja = 0;
        int alta = flota.length - 1;
        while (baja <= alta) {
            int media = (baja + alta) / 2;
            if (flota[media] != null && flota[media].getNombre().equals(s)) {
                return media;
            } else if (flota[media] != null && s.compareTo(flota[media].getNombre()) < 0) {
                alta = media - 1;
            } else {
                baja = media + 1;
            }
        }
        return -1;
    }
    //Método que ordena por número de puntos de menor a mayor

    public static void ordenarPorPuntosSeleccion(Nave[] flota) {
        for (int i = 0; i < flota.length - 1; i++) {
            for (int j = i + 1; j < flota.length; j++) {
                if (flota[i].getPuntos() > flota[j].getPuntos()) {
                    Nave temp = flota[i];
                    flota[i] = flota[j];
                    flota[j] = temp;
                }

            }

        }

    }
    //Método que ordena por nombre de A a Z

    public static void ordenarPorNombreSeleccion(Nave[] flota) {

        for (int i = 0; i < flota.length - 1; i++) {
            for (int j = i + 1; j < flota.length; j++) {
                if (flota[i].getNombre().compareTo(flota[j].getNombre()) > 0) {
                    Nave temp = flota[i];
                    flota[i] = flota[j];
                    flota[j] = temp;
                }

            }

        }

    }
    //Método que muestra las naves ordenadas por número de puntos de mayor a menor

    public static void ordenarPorPuntosInsercion(Nave[] flota) {
        for (int i = 1; i < flota.length; i++) {
            Nave temp = flota[i];
            int j = i - 1;

            while (j > -1 && flota[j].getPuntos() < temp.getPuntos()) {
                flota[j + 1] = flota[j];
                j -= 1;

            }
            flota[j + 1] = temp;

        }

    }
    //Método que muestra las naves ordenadas por nombre de Z a A
    public static void ordenarPorNombreInsercion(Nave[] flota) {
        for (int i = 1; i < flota.length; i++) {
            Nave temp = flota[i];
            int j = i - 1;
            
            while (j >= 0 && flota[j] != null && flota[j].getNombre().compareTo(temp.getNombre()) < 0) {
                flota[j + 1] = flota[j];
                j--;
            }
            flota[j + 1] = temp;
        }
    }

}
