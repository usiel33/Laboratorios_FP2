package Laboratorio_03;
//Laboratorio N° 3- Ejercicio 3
//Autor: Usiel Suriel Quispe Puma

import java.util.*;

public class EJERCICIO_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rdn = new Random();
        int cantSoldados1, cantSoldados2;

        //De manera aleatoria generamos la cantidad de soldados
        cantSoldados1 = rdn.nextInt(5) + 1;
        cantSoldados2 = rdn.nextInt(5) + 1;

        //Creamos objeto de la clase Ejercito
        Ejercito e1 = new Ejercito(cantSoldados1);
        Ejercito e2 = new Ejercito(cantSoldados2);

        //Inicializamos los datos de cada soldado
        e1.generarNombres();
        e2.generarNombres();

        //Mostramos datos de todos los soldado de cada ejercito
        System.out.println("\nDATOS DE LOS SOLDADOS DEL EJERCITO 1\n");
        e1.mostrarDatos();
        System.out.println("\nDATOS DE LOS SOLDADOS DEL EJERCITO 2\n");
        e2.mostrarDatos();

        //mostramos al ganador
        System.out.println("\n--------------------------------");
        mostrarGanador(cantSoldados1, cantSoldados2);
    }

    //Método para designar al ganador considerando la cantidad de soldados
    //ejercito
    public static void mostrarGanador(int cant1, int cant2) {
        if (cant1 > cant2) {
            System.out.println("GANADOR : EJERCITO 1   \nCantidad de soldados : "+cant1);
          
        } else if (cant2 > cant1) {
            System.out.println("GANADOR : EJERCITO 2   \nCantidad de soldados : " + cant2);
        } else {
            System.out.println("EMPATE !!");
            System.out.println("EJERCITO 1 : "+cant1+"    EJERCITO 2 : "+cant2);
        }
    }
}
