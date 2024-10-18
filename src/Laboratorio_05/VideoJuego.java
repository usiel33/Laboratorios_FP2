package Laboratorio_05;
//Laboratorio 05- Ejercicio 1
//Autor:Usiel Suriel Quispe Puma
import java.util.*;

public class VideoJuego {

    public static void main(String[] args) {
        int cantSoldados;
        String nombre;
        int fil, col, nivelVida;

        // creamos un arreglo bidimensional de 10x10
        Soldado soldados[][] = new Soldado[10][10];

        Random rd = new Random();
        cantSoldados = rd.nextInt(10) + 1;
        ArrayList<Soldado> listaSoldados = new ArrayList<>();

        // Ingresamos todos los datos de los soldados
        for (int i = 0; i < cantSoldados; i++) {
            nombre = "Soldado" + i;
            nivelVida = rd.nextInt(5) + 1;

            // Asignamos el soldado en una posición aleatoria vacía
            while (true) {
                fil = rd.nextInt(10);
                col = rd.nextInt(10);

                if (soldados[fil][col] == null) {
                    Soldado nuevoSoldado = new Soldado(nombre, nivelVida, fil, col);
                    soldados[fil][col] = nuevoSoldado;
                    listaSoldados.add(nuevoSoldado);
                    break;
                }
            }
        }

        // Mostrar el tablero de los soldados
        mostrarTablero(soldados);

        // Mostrar el soldado con la mayor vida
        mostrarSoldadoMayorVida(soldados);

        // Mostrar promedio de vida de todos los soldados
        mostrarPromedioVida(soldados);

        // Mostrar el nivel de vida total del ejército
        mostrarNivelVidaEjercito(soldados);

        // Mostrar los soldados en el orden que fueron creados
        mostrarSoldados(listaSoldados);

        // Mostrar ranking de poder de los soldados
        rankearSoldadosPorVida(listaSoldados);
    }

    //Método para mostrar el tablero con todos los soldados creados
    public static void mostrarTablero(Soldado[][] soldados) {
        System.out.println("Tablero de soldados:\n");
        System.out.println("    A  B  C  D  E  F  G  H  I  J");
        for (int i = 0; i < soldados.length; i++) {
            System.out.print((i + 1) + " "); // Ajuste para que las filas inicien correctamente desde 1
            for (int j = 0; j < soldados[0].length; j++) {
                if (soldados[i][j] != null) {
                    System.out.print("|S| ");
                } else {
                    System.out.print("|_| ");
                }
            }
            System.out.println();
        }
    }

    // Método que muestra el soldado con la mayor vida
    public static void mostrarSoldadoMayorVida(Soldado[][] soldados) {
        Soldado soldadoMayor = null;
        int mayorNivelVida = 0;
        for (int i = 0; i < soldados.length; i++) {
            for (int j = 0; j < soldados[0].length; j++) {
                if (soldados[i][j] != null && soldados[i][j].getNivelVida() > mayorNivelVida) {
                    soldadoMayor = soldados[i][j];
                    mayorNivelVida = soldados[i][j].getNivelVida();
                }
            }
        }
        // Verificamos si encontramos algún soldado en la tabla
        if (soldadoMayor != null) {
            System.out.println("\nEl soldado con mayor nivel de vida es:");
            soldadoMayor.mostrarDatos();
        } else {
            System.out.println("\nNo hay soldados en el tablero.");
        }
    }

    // Método que muestra el promedio de nivel de vida de todos los soldados
    public static void mostrarPromedioVida(Soldado[][] soldados) {
        int sumaVida = 0;
        int contadorSoldados = 0;
        float promedio;

        for (int i = 0; i < soldados.length; i++) {
            for (int j = 0; j < soldados[0].length; j++) {
                if (soldados[i][j] != null) {
                    sumaVida += soldados[i][j].getNivelVida();
                    contadorSoldados++;
                }
            }
        }

        // Verificamos si hay soldados
        if (contadorSoldados > 0) {
            promedio = (float) sumaVida / contadorSoldados;
            System.out.println("\nEl promedio de vida de los soldados  : " + promedio);
        } else {
            System.out.println("\nNo hay soldados en el tablero ");
        }
    }

    // Método para mostrar el nivel de vida total de todo el ejército
    public static void mostrarNivelVidaEjercito(Soldado[][] soldados) {
        int sumaVida = 0;

        for (int i = 0; i < soldados.length; i++) {
            for (int j = 0; j < soldados[0].length; j++) {
                if (soldados[i][j] != null) {
                    sumaVida += soldados[i][j].getNivelVida();
                }
            }
        }

        System.out.println("\nNivel de vida de todo el ejercito: " + sumaVida);
    }

    // Método para mostrar los soldados en el orden en que fueron creados
    public static void mostrarSoldados(ArrayList<Soldado> soldados) {
        System.out.println("\nSoldados en orden de creacion :");
        for (Soldado soldado : soldados) {
            soldado.mostrarDatos();
            System.out.println();
        }
    }

    // Método para rankear los soldados por nivel de vida
    public static void rankearSoldadosPorVida(ArrayList<Soldado> soldados) {
        for (int i = 0; i < soldados.size() - 1; i++) {
            for (int j = 0; j < soldados.size() - i - 1; j++) {
                if (soldados.get(j).getNivelVida() < soldados.get(j + 1).getNivelVida()) {
                    Soldado temp = soldados.get(j);
                    soldados.set(j, soldados.get(j + 1));
                    soldados.set(j + 1, temp);
                }
            }
        }

        // Mostrar ranking
        System.out.println("Ranking de poder de los soldados ( mayor al menor nivel de vida):\n");
        for (Soldado soldado : soldados) {
            soldado.mostrarDatos();
            System.out.println("");
        }
    }
}
