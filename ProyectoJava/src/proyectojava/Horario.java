/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

import java.util.ArrayList;

/**
 *
 * @author IYAC
 */
public abstract class Horario {
    static int n=0;
    static String[] A_Horario=new String[n];
    public static boolean Registrar_Horario(String Horario){
        //Hoario martes-12:00-15:00
        for (int i=0; i<A_Horario.length; i++){
            if(Horario.equalsIgnoreCase(A_Horario[i])){
                System.out.println("Este horario ya se encuentra registrado");
                return false;
            }}
        n+=1;
        String [] A1_Horario=new String[A_Horario.length];
        for (int j=0; j<A_Horario.length;j++){
            A1_Horario[j]=A_Horario[j];
        }
        A_Horario= new String [n];
        for (int k=0; k<A1_Horario.length;k++){
            A_Horario[k]=A1_Horario[k];
        }
        A_Horario[n-1]=Horario;
        System.out.println("El horario se ha guardado con éxito!");
        System.out.println("Listado de horario: ");
        for(int i=0; i<A_Horario.length;i++){
            System.out.println(A_Horario[i]);
        }
        return true;
        
        
        } 
    
        
    
}
