package Laboratorio_06;
//Laboratorio 6 - Ejercicio 1
//Autor: Usiel Suriel Quispe Puma
import java.util.ArrayList;
import java.util.Random;

public class VideoJuego3 {

    public static void main(String[] args) {
        int cantSoldados1, cantSoldados2;
        String nombre;
        int fil, col, nivelVida;

        ArrayList<ArrayList<Soldado>> e1Soldados = new ArrayList<>();
        ArrayList<ArrayList<Soldado>> e2Soldados = new ArrayList<>();
        ArrayList<Soldado> listaSoldadosE1 = new ArrayList<>();
        ArrayList<Soldado> listaSoldadosE2 = new ArrayList<>();
        Random rd = new Random();
        cantSoldados1 = rd.nextInt(10) + 1;
        cantSoldados2 = rd.nextInt(10) + 1;

        for (int i = 0; i < 10; i++) {
            e1Soldados.add(new ArrayList<Soldado>());
            e2Soldados.add(new ArrayList<Soldado>());
            for (int j = 0; j < 10; j++) {
                e1Soldados.get(i).add(null);
                e2Soldados.get(i).add(null);
            }
        }

        System.out.println("\tEjercito 1\n");

        //Asignamos soldados aleatorios al ejército 1
        for (int i = 0; i < cantSoldados1; i++) {
            nombre = "Soldado" + i + "X1";
            nivelVida = rd.nextInt(5) + 1;

            do {
                fil = rd.nextInt(10);
                col = rd.nextInt(10);
            } while (e1Soldados.get(fil).get(col) != null);

            Soldado nuevoSoldado = new Soldado(nombre, nivelVida, fil, col);
            e1Soldados.get(fil).set(col, nuevoSoldado);
            listaSoldadosE1.add(nuevoSoldado);
        }

        mostrarInformacion(e1Soldados, listaSoldadosE1, 1);

        System.out.println("\n\tEjercito 2\n");

        //Asignamos soldados aleatorios al ejército 2 sin ocupar posiciones del ejercito 1
        for (int i = 0; i < cantSoldados2; i++) {
            nombre = "Soldado" + i + "X2";
            nivelVida = rd.nextInt(5) + 1;

            do {
                fil = rd.nextInt(10);
                col = rd.nextInt(10);
            } while (e1Soldados.get(fil).get(col) != null || e2Soldados.get(fil).get(col) != null);

            Soldado nuevoSoldado = new Soldado(nombre, nivelVida, fil, col);
            e2Soldados.get(fil).set(col, nuevoSoldado);
            listaSoldadosE2.add(nuevoSoldado);
        }

        mostrarInformacion(e2Soldados, listaSoldadosE2, 2);
        mostrarGanador(listaSoldadosE1, listaSoldadosE2);
    }

    // Método para reutilizar código
    public static void mostrarInformacion(ArrayList<ArrayList<Soldado>> soldados, ArrayList<Soldado> listaSoldados, int ejercito) {
        // Mostrar el tablero de los soldados
        mostrarTablero(soldados, ejercito);

        // Mostrar el soldado con la mayor vida
        mostrarSoldadoMayorVida(soldados);

        // Mostrar promedio de vida de todos los soldados
        mostrarPromedioVida(soldados);

        // Mostrar el nivel de vida total del ejército
        mostrarNivelVidaEjercito(soldados);

        // Mostrar los soldados en el orden en que fueron creados
        mostrarSoldados(listaSoldados);

        // Mostrar ranking de poder de los soldados(dos algoritmos de ordenamiento)
        rankearSoldadosPorVidaBurbuja(listaSoldados);
        rankearSoldadosPorVidaInsercio(listaSoldados);
    }

    // Método para mostrar el tablero con todos los soldados creados
    public static void mostrarTablero(ArrayList<ArrayList<Soldado>> soldados, int ejercito) {
        System.out.println("Tablero de soldados del Ejercito " + ejercito + ":\n");
        System.out.println("   A   B   C   D   E   F   G   H   I   J");

        for (int i = 0; i < soldados.size(); i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 10; j++) {
                if (j < soldados.get(i).size() && soldados.get(i).get(j) != null) {
                    if (ejercito == 1) {
                        System.out.print("|1| ");
                    } else {
                        System.out.print("|2| ");
                    }
                } else {
                    System.out.print("|_| ");
                }
            }
            System.out.println();
        }
    }

    // Método que muestra el soldado con la mayor vida
    public static void mostrarSoldadoMayorVida(ArrayList<ArrayList<Soldado>> soldados) {
        Soldado soldadoMayor = null;
        int mayorNivelVida = 0;

        for (int i = 0; i < soldados.size(); i++) {
            for (int j = 0; j < soldados.get(i).size(); j++) {
                if (soldados.get(i).get(j) != null && soldados.get(i).get(j).getNivelVida() > mayorNivelVida) {
                    mayorNivelVida = soldados.get(i).get(j).getNivelVida();
                    soldadoMayor = soldados.get(i).get(j);
                }
            }
        }

        if (soldadoMayor != null) {
            System.out.println("\nEl soldado con mayor nivel de vida es :");
            soldadoMayor.mostrarDatos();
        } else {
            System.out.println("\nNo hay soldados en el tablero");
        }
    }

    // Método que muestra el promedio de nivel de vida de todos los soldados
    public static void mostrarPromedioVida(ArrayList<ArrayList<Soldado>> soldados) {
        int sumaVida = 0;
        int contadorSoldados = 0;

        for (int i = 0; i < soldados.size(); i++) {
            for (int j = 0; j < soldados.get(i).size(); j++) {
                if (soldados.get(i).get(j) != null) {
                    sumaVida += soldados.get(i).get(j).getNivelVida();
                    contadorSoldados++;
                }
            }
        }

        if (contadorSoldados > 0) {
            float promedio = (float) sumaVida / contadorSoldados;
            System.out.println("\nEl promedio de vida de los soldados : " + promedio);
        } else {
            System.out.println("\nNo hay soldados en el tablero");
        }
    }

    // Método para mostrar el nivel de vida total de todo el ejército
    public static void mostrarNivelVidaEjercito(ArrayList<ArrayList<Soldado>> soldados) {
        int sumaVida = 0;

        for (int i = 0; i < soldados.size(); i++) {
            for (int j = 0; j < soldados.get(i).size(); j++) {
                if (soldados.get(i).get(j) != null) {
                    sumaVida += soldados.get(i).get(j).getNivelVida();
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

    // Método para rankear los soldados por nivel de vida (burbuja)
    public static void rankearSoldadosPorVidaBurbuja(ArrayList<Soldado> soldados) {
        for (int i = 0; i < soldados.size() - 1; i++) {
            for (int j = 0; j < soldados.size() - i - 1; j++) {
                if (soldados.get(j).getNivelVida() < soldados.get(j + 1).getNivelVida()) {
                    Soldado temp = soldados.get(j);
                    soldados.set(j, soldados.get(j + 1));
                    soldados.set(j + 1, temp);
                }
            }
        }

        System.out.println("\nRanking de poder de los soldados (de mayor a menor nivel de vida): ");
        System.out.println("Ordenamiento por burbuja\n");
        for (Soldado soldado : soldados) {
            soldado.mostrarDatos();
            System.out.println("");
        }
    }

    //Método para rankear los soldados por nivel de vida (Insercion)
    public static void rankearSoldadosPorVidaInsercio(ArrayList<Soldado> soldados) {
        int n = soldados.size();

        for (int i = 1; i < n; i++) {
            Soldado soldadoActual = soldados.get(i);
            int j = i - 1;

            while (j >= 0 && soldados.get(j).getNivelVida() < soldadoActual.getNivelVida()) {
                soldados.set(j + 1, soldados.get(j));
                j--;
            }

            soldados.set(j + 1, soldadoActual);
        }

        System.out.println("\nOrdenamiento por insercion\n");
        for (Soldado soldado : soldados) {
            soldado.mostrarDatos();
            System.out.println("");
        }
    }

    // Método para motrar el ejército ganador
    public static void mostrarGanador(ArrayList<Soldado> listaSoldadosE1, ArrayList<Soldado> listaSoldadosE2) {
        int sumaVidaE1 = listaSoldadosE1.stream().mapToInt(Soldado::getNivelVida).sum();
        int sumaVidaE2 = listaSoldadosE2.stream().mapToInt(Soldado::getNivelVida).sum();

        System.out.println("\nSuma total de vida del Ejercito 1: " + sumaVidaE1);
        System.out.println("Suma total de vida del Ejercito 2: " + sumaVidaE2);
        System.out.print("\nGanador  segun la cantidad de vida total de cada ejercito :   ");
        if (sumaVidaE1 > sumaVidaE2) {
            System.out.println("El Ejercito 1 gana la batalla");
        } else if (sumaVidaE2 > sumaVidaE1) {
            System.out.println("El Ejercito 2 gana la batalla");
        } else {
            System.out.println("Empate!!");
        }
    }
}
