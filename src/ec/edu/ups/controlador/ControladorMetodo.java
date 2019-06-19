/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Palabras;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Domenika Delgado
 */
public class ControladorMetodo {
    
    //Atributos
    private String linea;
    private List<Palabras> lista;
    
    
    //Constructor 
    public ControladorMetodo() {
        lista = new ArrayList<>();
    }
    
    
     //*********************************************\\
    //********************METODOS********************\\
   //*************************************************\\
    
    
    //~~~~~~~~Metodo de Leer Archivos~~~~~~~~\\
   
            /*Lee archivo por archivo*/
    
    public void readDocument(String ruta) throws IOException {
        
        linea = "";
        
        try {
            //Leer los archivos que estan en la ruta
            FileReader archivo = new FileReader(ruta);
            BufferedReader read = new BufferedReader(archivo);
            
            while (linea != null) {
                linea = read.readLine();
                if (linea != null) {
                    readWords();
                }
            }

        } catch (FileNotFoundException ea) {

            System.out.println("Archivo no existe!");

        } catch (IOException el) {

            System.out.println("Error de Lectura de Archivo");

        }

    }
    

     //~~~~~~~~Metodo de verificacion~~~~~~~~\\
   
            /*Si son iguales,ver cuantas
            veces se repite esa palabra*/
    
    public void igualdad(String palabra) {

        //contador
        int cont = 0;
        
        for (Palabras p : lista) {

            if (p.getWord().equals(palabra)) {

                p.setCantidad(p.getCantidad() + 1);
                cont=1;

                break;

            }
        }

        if (cont == 0) {

            Palabras pa = new Palabras();
            pa.setWord(palabra);
            pa.setCantidad(1);
            lista.add(pa);

        }
    }
    
    //~~~~~~~~~~~Metodo de Leer~~~~~~~~~~~\\
    
          /*Lee palabra por palabra y 
          convierte todo a mayusculas*/
    
    public void readWords(){

        System.out.println("");
        System.out.println("--------------------");
        System.out.println("Palabras de Texto");
        System.out.println("--------------------");

        
        //cuando encuentra un espacio 
        String palabras[] = linea.split(" ");

        for (int i = 0; i < palabras.length; i++){
            /*llama al metodo de igualdad y muestra 
            las palabras encontradas y lo pone en minusculas*/
            
            igualdad(palabras[i].toLowerCase());
            
           //Imprime las palabras de cada texto
            System.out.println("(" + palabras[i] + ")");
            
        }
    }
    
    
    //~~~~~~~~~~~Metodo de Escribir~~~~~~~~~~~\\
    
          /*Imprime las palabras encontradas con 
          la cantidad,cuantas veces esa palabra se repitio*/
    
    public void writeWords () throws IOException{
        
        /*Collection es todo aquello que se puede recorrer
        & saber el tamaño.*/
        
        /*Recorre la colección de <Palabras>
        Sort = ordenar
        Ordenar los elementos presentes 
        en la lista en orden ascendente.*/
                
        Collections.sort(lista, new Comparator<Palabras>() {

            
            /*Comparar las palabras y ver su repeticion*/
            public int compare(Palabras p1, Palabras p2) {
                return p1.getWord().compareTo(p2.getWord());
            }

        });

        try {

            
            /*Crea un txt con los resultados despues 
            de leer todo los archivos en la ruta */
            
            String ruta = "C:\\Users\\Domenika Delgado\\Documents\\NetBeansProjects\\Practica06ManejoDeArchivosTexto\\src\\ec\\edu\\ups\\archivos\\resultado.txt";
            
            //Para escribir
            FileWriter archivo = new FileWriter(ruta, false);
            BufferedWriter write = new BufferedWriter(archivo);

            System.out.println("");
            System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
            System.out.println("         Resultados         ");
            System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
            System.out.println("");
            
            
            for (Palabras p1 : lista) {

                write.append(p1.getWord()+ " " + p1.getCantidad());
                write.newLine();
                System.out.println("~"+"[" +p1.getWord()+ "|" + p1.getCantidad() + "]");

            }

        /*todo que se abre, se debe cerrar 
          para que no siga escribiendo*/
            
            write.close();//Cierra el buffer
            archivo.close(); //Cierra archivos\\

        } catch (IndexOutOfBoundsException ex) {

            System.out.println("Error");

        }
        
    }
}
