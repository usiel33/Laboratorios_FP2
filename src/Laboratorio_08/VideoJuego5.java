package Laboratorio_08;

import java.util.*;

public class VideoJuego5 {

    public static void main(String[] args) {
        int cantSoldados1, cantSoldados2;
        String nombre;
        int fil, col, nivelVida;
        Scanner sc = new Scanner(System.in);
        String clave;

        //Crear dos hashMap para almacenar los soldados de cada ejericito(1 y 2)
        //clave : string      Valor: Objeto de la clase soldado
        HashMap<String, Soldado> e1Soldados = new HashMap<>(); //Integer para la posicion de cada soldado
        HashMap<String, Soldado> e2Soldados = new HashMap<>();

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
                    clave = "F" + fil + "c" + col;
                } while (e1Soldados.get(clave) != null);

                Soldado nuevoSoldado = new Soldado(nombre, nivelVida, fil, col);

                e1Soldados.put(clave, nuevoSoldado);//Agregamos un soldado en una posicion 

            }

            //Asignamos soldados aleatorios al ejército 2 sin ocupar posiciones del ejercito 1
            for (int i = 0; i < cantSoldados2; i++) {
                nombre = "Soldado" + i + "X2";
                nivelVida = rd.nextInt(5) + 1;

                do {
                    fil = rd.nextInt(10);
                    col = rd.nextInt(10);
                    clave = "F" + fil + "c" + col;
                } while (e1Soldados.get(clave) != null || e2Soldados.get(clave) != null);
                //verficar que en la posicion clave no este ocupada

                Soldado nuevoSoldado = new Soldado(nombre, nivelVida, fil, col);
                e2Soldados.put(clave, nuevoSoldado);

            }
            System.out.println("");

            //Mostrar el soldado de mayor vida, promedio de vida, nivel de vida total, lista de soldados
            //ranking de soldados segun nivel de vida
            mostrarTablero(e1Soldados, e2Soldados);

            System.out.println("\n\t\tEJERCITO 1\n");

            mostrarInformacion(e1Soldados);
            System.out.println("==========================================");
            System.out.println("\n\t\tEJERCITO 2\n");

            mostrarInformacion(e2Soldados);
            mostrarGanador(e1Soldados, e2Soldados);

            System.out.print("\nDesea iniciar otra batalla? (s/n) : ");
            seguirJuego = sc.next();
            if (seguirJuego.equals("s")) {

            }
        } while (seguirJuego.equalsIgnoreCase("s"));

    }

    // Método para reutilizar código
    public static void mostrarInformacion(HashMap<String, Soldado> soldados) {
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
        mostrarSoldados(soldados);

        // Mostrar ranking de poder de los soldados(dos algoritmos de ordenamiento)
        System.out.println("\n\tRANKING DE PODER DE LOS SOLDADOS(MAYOR A MENOR NIVEL DE VIDA)");
        rankearSoldadosPorVidaBurbuja(soldados);
        rankearSoldadosPorVidaInsercion(soldados);
    }

    // Método para mostrar el tablero con todos los soldados creados
    public static void mostrarTablero(HashMap<String, Soldado> e1Soldados, HashMap<String, Soldado> e2Soldados) {
        System.out.println("Tablero de soldados de los Ejercito :\n");
        System.out.println("----------------------------------");
        System.out.println("Soldados del primer ejercito  : E1 ");
        System.out.println("Soldados del segundo ejercito : E2");
        System.out.println("----------------------------------");
        System.out.println("Formato : 3(nivel vida) E2(Ejercito al que pertenece)\n");

        System.out.println("     A     B     C     D     E     F     G     H     I     J");

        for (int i = 0; i < 10; i++) {

            if (i < 9) {
                System.out.print((i + 1) + "  ");
            } else {
                System.out.print((i + 1) + " ");
            }

            for (int j = 0; j < 10; j++) {
                String clave = "F" + i + "c" + j;
                Soldado soldadoActual1 = e1Soldados.get(clave);
                Soldado soldadoActual2 = e2Soldados.get(clave);
                if (soldadoActual1 != null || soldadoActual2 != null) {
                    if (soldadoActual1 != null) {
                        System.out.print("|" + soldadoActual1.getNivelVida() + "E1| ");
                    } else {
                        System.out.print("|" + soldadoActual2.getNivelVida() + "E2| ");
                    }
                } else {
                    System.out.print("|___| ");
                }
            }
            System.out.println();
        }
    }

    // Método que muestra el soldado con la mayor vida
    public static void mostrarSoldadoMayorVida(HashMap<String, Soldado> soldados) {
        Soldado soldadoMayor = null;
        int mayorNivelVida = 0;
        for (Map.Entry<String, Soldado> entry : soldados.entrySet()) {

            Soldado soldadoActual = entry.getValue();

            if (soldadoActual != null && soldadoActual.getNivelVida() > mayorNivelVida) {

                soldadoMayor = soldadoActual;
                mayorNivelVida = soldadoActual.getNivelVida();

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
    public static void mostrarPromedioVida(HashMap< String, Soldado> soldados) {
        int sumaVida = 0;
        int contadorSoldados = 0;
        float promedio;

        for (Map.Entry<String, Soldado> entry : soldados.entrySet()) {
            Soldado soldadoActual = entry.getValue();

            if (soldadoActual != null) {
                sumaVida += soldadoActual.getNivelVida();
                contadorSoldados++;

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
    public static void mostrarNivelVidaEjercito(HashMap<String, Soldado> soldados) {
        int sumaVida = 0;

        for (Map.Entry<String, Soldado> entry : soldados.entrySet()) {
            Soldado soldadoActual = entry.getValue();

            if (soldadoActual != null) {
                sumaVida += soldadoActual.getNivelVida();
            }

        }

        System.out.println("\nNivel de vida de todo el ejercito: " + sumaVida);
    }

    // Método para mostrar los soldados en el orden en que fueron creados
    public static void mostrarSoldados(HashMap<String, Soldado> soldados) {
        Set< String> claves = soldados.keySet();
        for (String clave : claves) {
            soldados.get(clave).mostrarDatos();
            System.out.println();
        }
    }

    // Método para rankear los soldados por nivel de vida (burbuja)
    public static void rankearSoldadosPorVidaBurbuja(HashMap<String, Soldado> soldados) {
        ArrayList<Soldado> listaSoldados = new ArrayList<>(soldados.values());
        for (int i = 0; i < listaSoldados.size() - 1; i++) {
            for (int j = 0; j < listaSoldados.size() - i - 1; j++) {
                if (listaSoldados.get(j).getNivelVida() < listaSoldados.get(j + 1).getNivelVida()) {
                    Soldado temp = listaSoldados.get(j);
                    listaSoldados.set(j, listaSoldados.get(j + 1));
                    listaSoldados.set(j + 1, temp);
                }
            }
        }

        System.out.println("   Ordenamiento por burbuja\n");
        for (Soldado soldado : listaSoldados) {
            soldado.mostrarDatos();
            System.out.println("");
        }
    }

    //Método para rankear los soldados por nivel de vida (Insercion)
    public static void rankearSoldadosPorVidaInsercion(HashMap<String, Soldado> ejercitoSoldados) {
        ArrayList<Soldado> soldados = new ArrayList<>(ejercitoSoldados.values());
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
    public static void mostrarGanador(HashMap<String, Soldado> listaSoldadosE1, HashMap<String, Soldado> listaSoldadosE2) {
        int sumaVidaE1 = 0;
        int sumaVidaE2 = 0;

        System.out.println("\n\tRESULTADOS");
        System.out.println("=====================================");

        Set< String> claves = listaSoldadosE1.keySet();
        for (String clave : claves) {
            sumaVidaE1 += listaSoldadosE1.get(clave).getNivelVida();

        }
        Set< String> claves2 = listaSoldadosE2.keySet();
        for (String clave2 : claves2) {
            sumaVidaE2 += listaSoldadosE2.get(clave2).getNivelVida();

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
