/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author IYAC
 */
public class main2 {
    public static void main(String[] args)  {
        System.out.println("");
        ArrayList Estu= new ArrayList();
//        Estudiante e=new Estudiante("HArry",23,2);
//        Estudiante e1=new Estudiante("ZArry",24,1);
//        Estudiante e2=new Estudiante("OArry",33,21);
//        Estudiante e3=new Estudiante("RArry",2333,3);
//        Estudiante e4=new Estudiante("SArry",13,7);
//        Estudiante e5=new Estudiante("worry",2233,1);
//        Estudiante e6=new Estudiante("berry",2,12);
//        Estudiante e7=new Estudiante("cerry",27,62);
//        Estu.add(e);
//        Estu.add(e1);
//        Estu.add(e2);
//        Estu.add(e3);
//        Estu.add(e4);
//        Estu.add(e5);
//        Estu.add(e6);
//        Estu.add(e7);
    
        Collections.sort(Estu, Ordenar.EstudiantePorNombre);
        System.out.println("Por nombre");
        for (int i=0; i<Estu.size();i++){
            System.out.println(Estu.get(i));
        }
        
        
        Collections.sort(Estu, Ordenar.EstudiantePorEdad);
        System.out.println("Por edad");
        for (int i=0; i<Estu.size();i++){
            System.out.println(Estu.get(i));
        }
        
        
        
        Collections.sort(Estu, Ordenar.EstudiantePorMR);
        System.out.println("Por Materias Registradas");
        for (int i=0; i<Estu.size();i++){
            System.out.println(Estu.get(i));
        }
    }
}
