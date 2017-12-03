/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author IYAC
 */
public class Estudiante extends Usuario  {

    int MateriasRegistradas = 0;
//    public Estudiante(String nombre, int edad, int MateriasRegistradas){
//        super.nombre=nombre;
//        super.edad=edad;
//        this.MateriasRegistradas=MateriasRegistradas;
//    }
    public Estudiante(String nombre, String apellido, int edad, String casa, String varita,
            String Tipo_de_mago) {
        super.nombre = nombre;
        super.apellido = apellido;
        super.edad = edad;
        super.casa = casa;
        super.varita = varita;
        super.Tipo_de_mago = Tipo_de_mago;

    }
@Override
public String toString(){
    return ("El estudiante se llama "+nombre+" "+apellido+", edad "+edad+", tiene "+MateriasRegistradas+" Materias registradas vive en la casa "+casa+""
            + ", su varita es de "+varita+ ",y es un mago o hechicera de tipo "+Tipo_de_mago);
}
    public static void menu_estudiante() {
        Scanner sc = new Scanner(System.in);
        String opcion;
        int opc = 0;
        boolean flag = false;
        while (flag == false) {
            System.out.println("**************************************************");
            System.out.println("1. Ver cursos planificados");
            System.out.println("2. Registro");
            System.out.println("3. Descripción de vuelo");
            System.out.print("Ingrese la opción que desee: ");
            flag = true;
            opcion = sc.nextLine();
            try {
                opc = Integer.parseInt(opcion);
            } catch (Exception e) {
                System.out.println("");
                System.out.println("Error de ingreso. Por favor intente nuevamente.");
                flag = false;
            }
            if (flag == true) {
                if (opc < 0 || opc > 3) {
                    System.out.println("Su ingreso está fuera del rango de opciones. Por favor intente nuevamente");
                    flag = false;
                }
            }
        }
        
    if(opc==1){
        //Ver cursos planificados
        
        
    }
    if(opc==2){
        
    }
    if(opc==3){
        
    }
    /////////////////////////////////////////////////////Hacer un menu para salir
    
    menu_estudiante();
    }


    

    
   
}
