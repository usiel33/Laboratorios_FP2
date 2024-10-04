
package Laboratorio_03;

public class Soldado {
    private String nombre;
    private int nivelVida;
    
    //Metodo constructor
    public Soldado(String nombre,int nivelVida){
        this.nombre= nombre;
        this.nivelVida=nivelVida;
    }
    

    //metodo to strign para mostrar datos 
    @Override
    public String toString(){
        return "Nombre : "+nombre+"\t Nivel de Vida :  "+nivelVida;
        
    }
    
    
}
