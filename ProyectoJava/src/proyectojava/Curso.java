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

    String ubicacion = "curso.txt";
//Agrega un curso al archivo curso 
    public static void AgregarCurso(String ncurso) {
        String ubicacion = "curso.txt";
        try {
            FileWriter archivo = new FileWriter(ubicacion, true);

//        for( int i = 0;i <ncurso.length();i++){
//            escritura.write(ncurso.charAt(i));
//            escritura.w
//        }
            PrintWriter linea = new PrintWriter(archivo, true);
            linea.println(ncurso);
            linea.close();
            archivo.close();
            System.out.println("Su curso se ha agregado con exito!");
        } catch (Exception e) {
            System.out.println("Error con el archivo");
            System.out.println(e);
        }

    }
//Agrega un curso segun la materia y es uno especifico para planificador ya que se preseta la cantidad de estudiantes
    public static void ObtenerCursoP(String materia) throws FileNotFoundException, IOException {
        String ubicacion = "curso.txt";
        String cadena;
        int c = 0;
//        try {
        FileReader archivo = new FileReader(ubicacion);
        BufferedReader bf = new BufferedReader(archivo);

        while ((cadena = bf.readLine()) != null) {
            String m = cadena.split(",")[0];
            String[] linea = cadena.split(",");
            if (m.equalsIgnoreCase(materia) == true) {
                System.out.println("MATERIA: " + materia);
                System.out.println("PROFESOR: " + linea[1]);
                System.out.println("HORARIO: " + linea[2] + " " + linea[3]);
                System.out.println("REGISTRADOS: " + linea[4]);
                c += 1;
            }
        }
        if (c == 0) {
            System.out.println("No se encontro materia");
        }

    }
//Agrega un curso segun la materia y es uno especifico para estudiante ya que se NO presenta la cantidad de estudiantes
    public static void ObtenerCursoE(String materia) throws FileNotFoundException, IOException {
        String ubicacion = "curso.txt";
        String cadena;
        int c = 0;
//        try {
        FileReader archivo = new FileReader(ubicacion);
        BufferedReader bf = new BufferedReader(archivo);

        while ((cadena = bf.readLine()) != null) {
            String m = cadena.split(",")[0];
            String[] linea = cadena.split(",");
            if (m.equalsIgnoreCase(materia) == true) {
                System.out.println("MATERIA: " + materia);
                System.out.println("PROFESOR: " + linea[1]);
                System.out.println("HORARIO: " + linea[2] + " " + linea[3]);
                c += 1;
            }
        }
        if (c == 0) {
            System.out.println("No se encontro materia");
        }

    }
}
