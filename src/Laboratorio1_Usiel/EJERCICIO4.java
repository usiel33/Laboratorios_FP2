package Laboratorio1_Usiel;

//Laboratorio N° 1 - Ejercicio 5
//Autor: Usiel Suriel Quispe Puma
//colaboro :
//Tiempo : 20 min
import java.util.*;

public class EJERCICIO4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String soldados[] = new String[5];
        int nivelVida[] = new int[5];

        //Pedir nombres de los soldados
        for (int i = 0; i < soldados.length; i++) {
            System.out.print("Ingrese el nombre del soldado " + (i + 1) + " : ");
            soldados[i] = sc.next();

        }
        //cada soldadod tiene una cantidad de vida
        for (int i = 0; i < soldados.length; i++) {
            nivelVida[i] = random.nextInt(5) + 1;
        }

        //mostrar datos de cada soldado
        System.out.println("\nDATOS DE LOS SOLDADOS INGRESADOS \n");
        for (int i = 0; i < soldados.length; i++) {
            System.out.println("Nombre del soldado " + (i + 1) + " : " + soldados[i]);
            System.out.println("Nivel de vida del soldado " + soldados[i] + " : " + nivelVida[i] + "\n");
        }

    }

}
