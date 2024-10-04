package Laboratorio_03;

public class Ejercito {
    //Arreglo de objeto de la clase Soldado_2
    Soldado_2[] soldados;

    //Creamos un arreglo de objetos, e indicamos la cantidad de solados que se generara por cada ejercito
    public Ejercito(int cantidad) {
        soldados = new Soldado_2[cantidad];
    }

    //metodo para generar nombres de los doldados
    public void generarNombres() {
        for (int i = 0; i < soldados.length; i++) {
            String nombre;
            nombre = "Soldado" + i;
            soldados[i] = new Soldado_2(nombre);

        }

    }

    //Metodo para mostrar los datos de todos los soldados de cada ejercito
    public void mostrarDatos() {
        for (Soldado_2 e : soldados) {
            System.out.println(e.toString());
            System.out.println("\n");
        }

    }

}
