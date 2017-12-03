/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mi compu
 */
public class Horario {
    ArrayList<String> horario_texto = new ArrayList<String>();
    Scanner entrada= new Scanner(System.in);
    
    public int[] convertirEntero(String hora){
        String horaString[] = new String[2];
        int horaEntero [] = new int[2];
        horaString = hora.split(":");
        horaEntero[0] = Integer.parseInt(horaString[0]);
        horaEntero[1] = Integer.parseInt(horaString[1]);
        
        return horaEntero;
    }

    public void AgregarHorario(String dia, String horaIngreso, String horaSalida) {
       
      
        int [] horaIngresoEntero = convertirEntero(horaIngreso);
        int [] horaSalidaEntero = convertirEntero(horaSalida);
        
        
        while ((horaIngresoEntero[0] < horaSalidaEntero[0] || horaIngresoEntero[0] == horaSalidaEntero[0] && horaIngresoEntero[1] < horaSalidaEntero[1])==false) {
            System.out.println("Horas incorrectas,ingrese nuevamente");
            System.out.print("Ingrese hora inicial");
            horaIngreso=entrada.nextLine();
            System.out.println("Ingrese hora salida");
            horaSalida=entrada.nextLine();
            horaIngresoEntero= convertirEntero(horaIngreso);
            horaSalidaEntero= convertirEntero(horaSalida);
            }
        horario_texto.add(dia+"-"+horaIngreso+"-"+horaSalida);
    }
            

    public boolean HorarioDisponible(String diaB, String horaIngreso, String horaSalida) {
        
        boolean flag2 = false;
        int [] horaIngresoEntero = convertirEntero(horaIngreso);
        int [] horaSalidaEntero = convertirEntero(horaSalida);

       
        
        while ((horaIngresoEntero[0] < horaSalidaEntero[0] || horaIngresoEntero[0] == horaSalidaEntero[0] && horaIngresoEntero[1] < horaSalidaEntero[1])==false) {
            System.out.println("Horas incorrectas,ingrese nuevamente");
            System.out.print("Ingrese hora inicial");
            horaIngreso=entrada.nextLine();
            System.out.println("Ingrese hora salida");
            horaSalida=entrada.nextLine();
            horaIngresoEntero= convertirEntero(horaIngreso);
            horaSalidaEntero= convertirEntero(horaSalida);
            }
        
        
        
            String temporal[] = new String[3];
            int temporalhora1[] = new int  [2];
            int temporalhora2[] = new int[2];

            for (String fecha :horario_texto) {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    

