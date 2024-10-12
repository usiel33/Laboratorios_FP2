
package Laboratorio1_Usiel;
//Laboratorio N° 1 - Ejercicio 3
//Autor: Usiel Suriel Quispe Puma
//colaboro :
//Tiempo : 20 min
import java.util.*;

public class EJERCICIO3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String soldados[] = new String[5];
        System.out.println("INGRESE DATOS DE LOS SOLDADOS \n");
        for (int i = 0; i < soldados.length; i++) {
            System.out.print("Ingrese el nombre del soldado " + (i + 1) + " : ");
            soldados[i] = sc.next();

        }
        System.out.println("\nNOMBRES DE LOS SOLDADOS INGRESADOS\n ");
        for (int i = 0; i < soldados.length; i++) {
            System.out.println("Nombre del soldado " + (i + 1) + " : " + soldados[i]);

        }

    }

}
