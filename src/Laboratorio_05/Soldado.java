package Laboratorio_05;
//Laboratorio 05- Ejercicio 1- Clase Soldado
//Autor:Usiel Suriel Quispe Puma
public class Soldado {
    // Atributos privados
    private String nombre;
    private int nivelVida;
    private int fila;
    private int columna;

    public Soldado(String nombre, int nivelVida, int fila, int columna) {
        this.nombre = nombre;
        this.nivelVida = nivelVida;
        this.fila = fila;
        this.columna = columna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    public void setNivelVida(int nivelVida) {
        this.nivelVida = nivelVida;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    // Metodo para mostrar datos de cada soldado
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Nivel de Vida: " + nivelVida);
        System.out.println("Posicion: Fila " + (fila+1) + ", Columna " 
                + (char)(columna + 'A'));
    }
}
