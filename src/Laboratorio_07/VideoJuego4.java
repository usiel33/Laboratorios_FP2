package Laboratorio_07;

import java.util.*;

public class VideoJuego4 {

    public static void main(String[] args) {
        int cantSoldados1, cantSoldados2;
        String nombre;
        int fil, col, nivelVida;
        Scanner sc = new Scanner(System.in);

        Soldado e1Soldados[][] = new Soldado[10][10];
        Soldado e2Soldados[][] = new Soldado[10][10];

        ArrayList<Soldado> listaSoldadosE1 = new ArrayList<>();
        ArrayList<Soldado> listaSoldadosE2 = new ArrayList<>();
        Random rd = new Random();

        String seguirJuego;
        System.out.println("\tBATALLA DE EJERCITOS \n");
        do {
            cantSoldados1 = rd.nextInt(10) + 1;
            cantSoldados2 = rd.nextInt(10) + 1;

            //Asignamos soldados aleatorios al ejército 1
            for (int i = 0; i < cantSoldados1; i++) {
                nombre = "Soldado" + i + "X1";
                nivelVida = rd.nextInt(5) + 1;

                //Evitar que haya soldados en la misma posicion
                do {
                    fil = rd.nextInt(10);
                    col = rd.nextInt(10);
                } while (e1Soldados[fil][col] != null);

                Soldado nuevoSoldado = new Soldado(nombre, nivelVida, fil, col);

                e1Soldados[fil][col] = nuevoSoldado;
                listaSoldadosE1.add(nuevoSoldado);
            }

            //Asignamos soldados aleatorios al ejército 2 sin ocupar posiciones del ejercito 1
            for (int i = 0; i < cantSoldados2; i++) {
                nombre = "Soldado" + i + "X2";
                nivelVida = rd.nextInt(5) + 1;

                do {
                    fil = rd.nextInt(10);
                    col = rd.nextInt(10);
                } while (e1Soldados[fil][col] != null || e2Soldados[fil][col] != null);

                Soldado nuevoSoldado = new Soldado(nombre, nivelVida, fil, col);
                e2Soldados[fil][col] = nuevoSoldado;
                listaSoldadosE2.add(nuevoSoldado);
            }
            System.out.println("");

            //Mostrar el soladado de mayor vida, promedio de vida, nivel de vida total, lista de soldados
            //ranking de soldados segun nivel de vida
            mostrarTablero(e1Soldados, e2Soldados);

            System.out.println("\n\t\tEJERCITO 1\n");

            mostrarInformacion(e1Soldados, listaSoldadosE1);
            System.out.println("==========================================");
            System.out.println("\n\t\tEJERCITO 2\n");

            mostrarInformacion(e2Soldados, listaSoldadosE2);
            mostrarGanador(listaSoldadosE1, listaSoldadosE2);

            System.out.print("\nDesea iniciar otra batalla? (s/n) : ");
            seguirJuego = sc.next();
            if (seguirJuego.equals("s")) {

            }
        } while (seguirJuego.equals("s"));

    }

    // Método para reutilizar código
    public static void mostrarInformacion(Soldado soldados[][], ArrayList<Soldado> listaSoldados) {
        // Mostrar el soldado con la mayor vida
        System.out.println("\n\tSOLDADO CON MAS VIDA");
        mostrarSoldadoMayorVida(soldados);

        System.out.println("\n\tPROMEDIO DE NIVEL DE VIDA DE LOS SOLDADOS ");
        // Mostrar promedio de vida de todos los soldados
        mostrarPromedioVida(soldados);
        System.out.println("\n\tDE NIVEL DE VIDA TOTAL DEL EJERCITO ");
        // Mostrar el nivel de vida total del ejército
        mostrarNivelVidaEjercito(soldados);

        // Mostrar los soldados en el orden en que fueron creados
        System.out.println("\n\tLISTA DE SOLDADOS EN ORDEN DE CREACION\n");
        mostrarSoldados(listaSoldados);

        // Mostrar ranking de poder de los soldados(dos algoritmos de ordenamiento)
        System.out.println("\n\tRANKING DE PODER DE LOS SOLDADOS(MAYOR A MENOR NIVEL DE VIDA)");
        rankearSoldadosPorVidaBurbuja(listaSoldados);
        rankearSoldadosPorVidaInsercion(listaSoldados);
    }

    // Método para mostrar el tablero con todos los soldados creados
    public static void mostrarTablero(Soldado[][] e1Soldados, Soldado[][] e2Soldados) {
        System.out.println("Tablero de soldados de los Ejercito :\n");
        System.out.println("----------------------------------");
        System.out.println("Soldados del primer ejercito  : E1 ");
        System.out.println("Soldados del segundo ejercito : E2");
        System.out.println("----------------------------------");
        System.out.println("Formato : 3(nivel vida) E2(Ejercito al que pertenece)\n");

        System.out.println("     A     B     C     D     E     F     G     H     I     J");

        for (int i = 0; i < e1Soldados.length; i++) {

            if (i < 9) {
                System.out.print((i + 1) + "  ");
            } else {
                System.out.print((i + 1) + " ");
            }

            for (int j = 0; j < 10; j++) {

                if (e1Soldados[i][j] != null || e2Soldados[i][j] != null) {
                    if (e1Soldados[i][j] != null) {
                        System.out.print("|" + e1Soldados[i][j].getNivelVida() + "E1| ");
                    } else {
                        System.out.print("|" + e2Soldados[i][j].getNivelVida() + "E2| ");
                    }
                } else {
                    System.out.print("|___| ");
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
            System.out.println("Cantidad de soldados en total : " + contadorSoldados);
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

        System.out.println("   Ordenamiento por burbuja\n");
        for (Soldado soldado : soldados) {
            soldado.mostrarDatos();
            System.out.println("");
        }
    }

    //Método para rankear los soldados por nivel de vida (Insercion)
    public static void rankearSoldadosPorVidaInsercion(ArrayList<Soldado> soldados) {
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

        System.out.println("\n   Ordenamiento por insercion\n");
        for (Soldado soldado : soldados) {
            soldado.mostrarDatos();
            System.out.println("");
        }
    }

    // Método para motrar el ejército ganador
    public static void mostrarGanador(ArrayList<Soldado> listaSoldadosE1, ArrayList<Soldado> listaSoldadosE2) {
        int sumaVidaE1 = 0;
        int sumaVidaE2 = 0;

        System.out.println("\n\tRESULTADOS");
        System.out.println("=====================================");
        for (Soldado s1 : listaSoldadosE1) {
            sumaVidaE1 += s1.getNivelVida();

        }
        for (Soldado s2 : listaSoldadosE2) {
            sumaVidaE2 += s2.getNivelVida();

        }

        System.out.println("\nSuma total de vida del Ejercito 1: " + sumaVidaE1);
        System.out.println("Suma total de vida del Ejercito 2: " + sumaVidaE2);
        System.out.println("\nGanador  segun la cantidad de vida total de cada ejercito :   ");
        if (sumaVidaE1 > sumaVidaE2) {
            System.out.println("El EJERCITO 1 gana la batalla");
        } else if (sumaVidaE2 > sumaVidaE1) {
            System.out.println("El EJERCITO 2 gana la batalla");
        } else {
            System.out.println("Empate!!");
        }
    }
}
