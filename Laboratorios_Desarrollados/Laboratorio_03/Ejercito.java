package Laboratorio_03;
//Laboratorio N° 3- Ejercicio 3
//Autor: Usiel Suriel Quispe Puma

public class Ejercito {

    //Arreglo de objeto de la clase Soldado_2
    Soldado_2[] soldados;

    //Creamos un arreglo de objetos, e indicamos la cantidad de solados que se generara por cada ejercito
    public Ejercito(int cantidad) {
        soldados = new Soldado_2[cantidad];
    }

    //metodo para generar nombres de los doldados
    public void generarNombres() {
        int id;
        for (int i = 0; i < soldados.length; i++) {
            id=(int)(Math.random()*100);
            String nombre;
            nombre = "Soldado" + id;
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
