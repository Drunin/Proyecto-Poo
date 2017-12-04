/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IYAC
 */
public class Profesor extends Usuario {

    static void AgregarProfesor(String nombre, String apellido, String edad, String casa, String varita, String Tipo_de_mago, String animal, String hechizo, String pocion, String deporte, String hechizo0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     String fechaingreso;
    public Profesor(String nombre,String apellido,int edad,String casa,String varita, 
            String Tipo_de_mago,String animal,String hechizo, String pocion,String deporte, String fecha_ingreso){
        super.nombre=nombre;
        super.apellido=apellido;
        super.edad=edad;
        super.casa=casa;
        super.varita=varita;
        super.Tipo_de_mago=Tipo_de_mago;
        super.animal=animal;
        super.pocion=pocion;
        super.deporte=deporte;
        super.hechizo=hechizo;
        this.fechaingreso=fecha_ingreso;
                
    }
    public static void AgregarProfesor(String nombre,String apellido,String edad,String varita, 
            String Tipo_de_mago,String animal,String hechizo, String pocion,
            String deporte, String fecha_ingreso){
    String ubicacion ="profesor.txt";
        try{
        FileWriter archivo = new FileWriter(ubicacion,true);
        
//        for( int i = 0;i <ncurso.length();i++){
//            escritura.write(ncurso.charAt(i));
//            escritura.w
//        }
        PrintWriter linea = new PrintWriter(archivo,true);
        linea.println(nombre + "," + apellido + "," +edad+ "," +varita+ "," +fecha_ingreso+ "," +
                Tipo_de_mago+ "," +animal+ "," +hechizo+ "," +pocion+ "," +deporte) ;
        linea.close();
        archivo.close();
    }
    
    catch(Exception e){
        System.out.println("Error con el archivo");
        System.out.println(e);       
        }
    }
    
    
    public static int LineasArchivo (){
        File input = new File("curso.txt"); 
        int numLines = 0;
        try {
            Scanner iterate = new Scanner(input);
            //int numLines=0; 
            while(iterate.hasNextLine()) { 
                String currLine=iterate.nextLine(); 
                numLines++; }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numLines;
    }    
    
    
    public static String [] ListaProfesores(String curso){
        String ubicacion ="profesores.txt";
        String cadena;
        String profesores = "";
        try {
            FileReader archivo = new FileReader(ubicacion);
            BufferedReader bf = new BufferedReader(archivo);
            
            while ((cadena = bf.readLine()) != null) {
                String [] m = cadena.split(",");
                profesores = m[0] + "," ;
                             
            }           
            
        } catch (Exception ex) {
            System.out.println("Error con el archivo");
            
        }
        
        String [] Arrayprofesores = profesores.split(",");
        return Arrayprofesores;
    }
    
    
    
}
