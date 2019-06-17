/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

/**
 *
 * @author Domenika Delgado
 */
public class Palabras {
    
    //Atributos
    private String word;
    private int cantidad;
    
    

    //Getters & Setters 
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    //toString
    @Override
    public String toString() {
        return "Palabras{" + "word=" + word + ", cantidad=" + cantidad + '}';
    }
    
    
}
