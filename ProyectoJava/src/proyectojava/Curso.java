/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Curso {
    String ubicacion ="curso.txt";    
        
        
    
    
    public static void AgregarCruso(String ncurso){
    String ubicacion ="curso.txt";
        try{
        FileWriter archivo = new FileWriter(ubicacion,true);
        
//        for( int i = 0;i <ncurso.length();i++){
//            escritura.write(ncurso.charAt(i));
//            escritura.w
//        }
        PrintWriter linea = new PrintWriter(archivo,true);
        linea.println(ncurso);
        linea.close();
        archivo.close();
    }
    
    catch(Exception e){
        System.out.println("Error con el archivo");
        System.out.println(e);       
        }
    
        
    }
    
    public static String ObtenerCurso(String materia){
        String ubicacion ="curso.txt";
        String cadena;
        try {
            FileReader archivo = new FileReader(ubicacion);
            BufferedReader bf = new BufferedReader(archivo);
            
            while ((cadena = bf.readLine()) != null) {
                String m = cadena.split(",")[0];
                if(m.equalsIgnoreCase(materia) == true){
                    return cadena;
                }
            }
            System.out.println("No se encontro materia");
            
            
        } catch (Exception ex) {
            System.out.println("Error con el archivo");
            
        }
        return null;
        
    }
    
}
