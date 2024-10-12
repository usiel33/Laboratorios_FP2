package Laboratorio_03;
//Laboratorio N° 3- Ejercicio 3
//Autor: Usiel Suriel Quispe Puma

public class Soldado_2 {

    private String nombre;

    public Soldado_2(String nombre) {
        this.nombre = nombre;
    }
    //Metodo to String para mostrar datos de los soldados

    @Override
    public String toString() {
        return "Nombre : " + nombre;
    }

}
