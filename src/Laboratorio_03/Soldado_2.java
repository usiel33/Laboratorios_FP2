package Laboratorio_03;

public class Soldado_2 {

    private String nombre;

    public Soldado_2(String nombre) {
        this.nombre = nombre;
    }
    //Metodo to String para mostrar datos de los soldados

    @Override
    public String toString() {
        System.out.println("Nombre : " + nombre);
        return nombre;
    }

}
