package Laboratorio_03;

//Laboratorio N° 3- Ejercicio 1
//Autor: Usiel Suriel Quispe Puma
public class Nave {

    private String nombre;
    private int fila;
    private String columna;
    private boolean estado;
    private int puntos;
// Metodos mutadores

    public void setNombre(String n) {
        nombre = n;
    }

    public void setFila(int f) {
        fila = f;
    }

    public void setColumna(String c) {
        columna = c;
    }

    public void setEstado(boolean e) {
        estado = e;
    }

    public void setPuntos(int p) {
        puntos = p;
    }
// Metodos accesores

    public String getNombre() {
        return nombre;
    }

    public int getFila() {
        return fila;
    }

    public String getColumna() {
        return columna;
    }

    public boolean getEstado() {
        return estado;
    }

    public int getPuntos() {
        return puntos;
    }

    public void mostrarDatos() {
        System.out.println("Nombre : " + nombre);
        System.out.println("fila: " + fila + "     Columna : " + columna);
        System.out.println("puntos : " + puntos);
        System.out.println("Estado : " + estado);
    }

}
