package Laboratorio_03;

/*Actividad 5: escribir un programa donde se creen 2 ejércitos, cada uno con un número aleatorio de soldados entre
1 y 5, considerando sólo su nombre. Sus datos se inicializan automáticamente con nombres tales como “Soldado0”,
“Soldado1”, etc. Luego de crear los 2 ejércitos se deben mostrar los datos de todos los soldados de ambos ejércitos
e indicar qué ejército fue el ganador.
Restricción: aplicar arreglos estándar y métodos para inicializar los ejércitos, mostrar ejército y mostrar ejército
ganador. La métrica a aplicar para indicar el ganador es el mayor número de soldados de cada ejército, puede
haber empates. (Todavía no aplicar arreglo de objetos)*/
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
        System.out.println("\n------------------------");
        mostrarGanador(cantSoldados1, cantSoldados2);
    }

    //metodo para designar al ganador considerando la cantidad de soldados
    //ejercito
    public static void mostrarGanador(int cant1, int cant2) {
        if (cant1 > cant2) {
            System.out.println("GANADOR : EJERCITO 1");
        } else if (cant2 > cant1) {
            System.out.println("GANADOR : EJERCITO 2");
        } else {
            System.out.println("EMPATE !!");
        }

    }

}
