/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorMetodo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Domenika Delgado
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        ControladorMetodo cm = new ControladorMetodo();
        
        String ruta = "C:\\Users\\Domenika Delgado\\Documents\\NetBeansProjects\\Practica06ManejoDeArchivosTexto\\src\\ec\\edu\\ups\\archivos";
        
        File a1 = new File(ruta);
        File[] a2 = a1.listFiles();
        for (File ar : a2) {
            if (!ar.getName().equals("resultado.txt")) {   
                cm.readDocument(ruta + "\\" + ar.getName());     
            }
        }    
        cm.writeWords();
    }
    
}
    

