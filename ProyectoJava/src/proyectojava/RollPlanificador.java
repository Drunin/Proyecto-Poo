/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;
import java.util.Scanner;
/**
 *
 * @author Mi compu
 */
public class RollPlanificador extends Usuario {
    Scanner sc = new Scanner(System.in);
    
    static public  void CrearCurso(String materia, String profesor, String dia, String horario, String capacidad){
    String datoscurso = materia + "," + profesor + "," + dia + "," + horario + "," + capacidad ;
    String fecha = dia + "-" + horario ;
    Curso.AgregarCruso(datoscurso);
    }
    
    
    
    public  void CrearProfesor(){
        System.out.println("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        
        System.out.println("Ingrese el apellido: ");
        String apellido = sc.nextLine();
        
        System.out.println("Ingrese la edad: ");
        String edad = sc.nextLine();
        
        System.out.println("Ingrese el nombre de su varita: ");
        String varita  = sc.nextLine();
        
        System.out.println("Ingrese su fecha de ingreso: ");
        String fecha_ingreso  = sc.nextLine();
        
        System.out.println("Tipos de magos");
        System.out.println("1. Animago");
        System.out.println("2. Metamorfomago");
        System.out.println("3. Estandar");
        String opcion = sc.nextLine();
        if(opcion.equalsIgnoreCase("1")){
            String Tipo_de_mago = "A";
            System.out.println("En que animal puede convertirse");
            String animal = sc.nextLine();
            String hechizo = null;
            System.out.println("Que pocion utiliza");
            String pocion = sc.nextLine();
            String deporte =null;
        }
        if(opcion.equalsIgnoreCase("2")){
            String Tipo_de_mago = "M";
            System.out.println("En que animal puede convertirse");
            String animal = null;
            String hechizo = null;
            System.out.println("Que pocion utiliza");
            String pocion = sc.nextLine();
            String deporte =null;
        
            
        }
        if(opcion.equalsIgnoreCase("3")){
            String Tipo_de_mago = "N";
            String animal = "";
            String hechizo = "";
            String pocion = "";
            System.out.println("Que deporte hace");
            String deporte =sc.nextLine();
        }
        
        Profesor.AgregarProfesor(nombre, apellido, edad, varita, Tipo_de_mago, animal, hechizo, pocion, deporte, fecha_ingreso);
    }
    
    
    
    public  void CrearEstudiante(){
                System.out.println("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        
        System.out.println("Ingrese el apellido: ");
        String apellido = sc.nextLine();
        
        System.out.println("Ingrese la edad: ");
        String edad = sc.nextLine();
        
        System.out.println("Ingrese el nombre de su varita: ");
        String varita  = sc.nextLine();
        
        System.out.println("Ingrese el nombre de su casa: ");
        String casa  = sc.nextLine();
        
        System.out.println("Tipos de magos");
        System.out.println("1. Animago");
        System.out.println("2. Metamorfomago");
        System.out.println("3. Estandar");
        String opcion = sc.nextLine();
        if(opcion.equalsIgnoreCase("1")){
            String Tipo_de_mago = "A";
           
        }
        if(opcion.equalsIgnoreCase("2")){
            String Tipo_de_mago = "M";
           
        
            
        }
        if(opcion.equalsIgnoreCase("3")){
            String Tipo_de_mago = "N";
        
        }
        Estudiante.AgregarEstudiante(nombre, apellido, edad, varita, casa, Tipo_de_mago);
        
    
    }
    public void VerHorarios(String materia){
    
    Curso.ObtenerCurso(materia);
    }
    
    
    
    public  void ListaEstuadiante(){}
    
    
}
