/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Mi compu
 */
public class Registro {

    public static int ObtenerEdad(String nombre, String apellido) {
        String ubicacion = "estudiantes.txt";
        String cadena;
        int edad = 0;
        try {
            FileReader archivo = new FileReader(ubicacion);
            BufferedReader bf = new BufferedReader(archivo);

            while ((cadena = bf.readLine()) != null) {
                String n = cadena.split(",")[0];
                String a = cadena.split(",")[1];

                if ((nombre.equalsIgnoreCase(n) & apellido.equalsIgnoreCase(a)) == true) {
                    edad += Integer.parseInt(cadena.split(",")[2]);
                }
            }

        } catch (Exception ex) {
            System.out.println("Error con el archivo");

        }
        return edad;
    }

    public static void AgregarRegistro(String fecha, String nombre, String apellido,
            String materia, int edad) {

        String tipo;
        String ubicacion = "registro.txt";
        if ((materia.equalsIgnoreCase("Pociones") | materia.equalsIgnoreCase("Defensa contra las artes oscuras")
                | materia.equalsIgnoreCase("Adivinación")) & (edad <= 15) == true) {

            tipo = "E";
        } else {
            tipo = "N";

        }
        try {
            FileWriter archivo = new FileWriter(ubicacion, true);

//        for( int i = 0;i <ncurso.length();i++){
//            escritura.write(ncurso.charAt(i));
//            escritura.w
//        }
            PrintWriter linea = new PrintWriter(archivo, true);
            linea.println(fecha + "," + nombre + "," + apellido + "," + materia + "," + tipo);
            linea.close();
            archivo.close();
        } catch (Exception e) {
            System.out.println("Error con el archivo");
            System.out.println(e);
        }

    }

    public static String ObtenerTipo(String nombre, String apellido) {
        String ubicacion = "estudiantes.txt";
        String cadena;
        String tipo = "";
        try {
            FileReader archivo = new FileReader(ubicacion);
            BufferedReader bf = new BufferedReader(archivo);

            while ((cadena = bf.readLine()) != null) {
                String n = cadena.split(",")[0];
                String a = cadena.split(",")[1];

                if ((nombre.equalsIgnoreCase(n) & apellido.equalsIgnoreCase(a)) == true) {
                    tipo = cadena.split(",")[5];
                }
            }

        } catch (Exception ex) {
            System.out.println("Error con el archivo");

        }
        return tipo;
    }
}
