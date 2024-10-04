package Laboratorio_03;

import java.util.*;

public class EJERCICIO_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nombre;
        int nivelVida;

        //Arreglo de objeto de la clase soldados
        Soldado[] soldados = new Soldado[5];
        ingresarDatos(soldados, sc);
        System.out.println("=============================");
        System.out.println("\n\tSOLDADOS INGRESADOS\n");
        mostrarDatos(soldados);

    }

    //metodo para llenar datos del arreglo
    public static void ingresarDatos(Soldado[] soldados, Scanner sc) {
        String nombre;
        int nivelVida;

        for (int i = 0; i < soldados.length; i++) {
            System.out.println("\n\tSOLDADO "+(i+1));
            System.out.print("Ingrese el nombre  : ");
            nombre = sc.next();
            System.out.print("Ingrese su nivel de vida : ");
            nivelVida = sc.nextInt();
            //Ingresmos los datos al objeto
            soldados[i]= new Soldado(nombre, nivelVida);
            
            
        }

    }
    //Metodo para mostrar los datos de cada soldado
    public static void mostrarDatos(Soldado [] soldados){
        for(Soldado a : soldados){
            System.out.println( a.toString());
            System.out.println("------------------------------------\n");
            
        }
        
    }

}
