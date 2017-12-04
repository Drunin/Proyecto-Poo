/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;
import static proyectojava.Planificador.MateriasGenerales;
import static proyectojava.Planificador.tipo_mago;

/**
 *
 * @author IYAC
 */
public class Estudiante extends Usuario {

    int MateriasRegistradas = 0;

    public Estudiante() {
        super.nombre = "";
        super.apellido = "";
        super.edad = 0;
        super.casa = "";
        super.varita = "";
        super.Tipo_de_mago = "";
    }

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
    public String toString() {
        return ("El estudiante se llama " + nombre + " " + apellido + ", edad " + edad + ", tiene " + MateriasRegistradas + " Materias registradas vive en la casa " + casa + ""
                + ", su varita es de " + varita + ",y es un mago o hechicera de tipo " + Tipo_de_mago);
    }

    public void menu_estudiante(String n) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] nomape = new String[2];
        nomape = n.split("-");
        String nombre = nomape[0];
        String apellido = nomape[1];
        String tipo = Registro.ObtenerTipo(nombre, apellido);
        int edad = Registro.ObtenerEdad(nombre, apellido);
        //Final ingreso edad 
        System.out.println("");
        System.out.println("MENÚ DE ESTUDIANTE");
        String opcion;
        int opc = 0;
        boolean flag = false;
        while (flag == false) {
            System.out.println("**************************************************");
            System.out.println("1. Ver cursos planificados");
            System.out.println("2. Registro");
            System.out.println("3. Descripción de vuelo");
            System.out.println("4. Salir");
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
                if (opc < 0 || opc > 4) {
                    System.out.println("Su ingreso está fuera del rango de opciones. Por favor intente nuevamente");
                    flag = false;
                }
            }
        }
        while (opc != 4) {
            if (opc == 1) {
                opc = 4;
                //Ver cursos planificados
                System.out.println("MATERIAS");
                for (int i = 0; i < 8; i++) {
                    System.out.println(i + 1 + ". " + MateriasGenerales[i]);
                }
                System.out.println("Eliga una materia del listado: ");
                int num = sc.nextInt();
                String materia = MateriasGenerales[num - 1];
                Curso.ObtenerCursoE(materia);
                opc = 4;
                menu_estudiante(n);

            }
            if (opc == 2) { //Registro
                opc = 4;
                String horario = "";
                System.out.println("MATERIAS");
                for (int i = 0; i < 8; i++) {
                    System.out.println(i + 1 + ". " + MateriasGenerales[i]);
                }
                System.out.println("Eliga una materia del listado: ");
                int num = sc.nextInt();
                String materia = MateriasGenerales[num - 1];
                String ubicacion = "curso.txt";
                String cadena;
                String cp = sc.nextLine();
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
                        horario = linea[2] + " " + linea[3];

                        break;
                    }
                }
                if (c == 0) {
                    System.out.println("No se encontro un curso con esta materia!");
                } else {
                    System.out.println("¿Desea registrarse? Si: S || No: Cualquier letra");
                    String r = sc.nextLine();
                    if (r.equalsIgnoreCase("S")) {
                        Registro.AgregarRegistro(horario, nombre, apellido, materia, edad);
                        System.out.println("Sus datos se han guardado con éxito!");
                        opc = 4;
                        menu_estudiante(n);
                    }
                }
                opc = 4;
                menu_estudiante(n);
            }
            if (opc == 3) { //DEscripcion del vuelo
                opc = 4;
                volar(tipo);

                menu_estudiante(n);
            }
            /////////////////////////////////////////////////////Hacer un menu para salir
            opc = 4;
            menu_estudiante(n);
        }
    }

    public void volar(String tipo) {
        if (tipo.equalsIgnoreCase("a")) {
            System.out.println("Usted es un Animago para volar necesita ayuda de su varita.");
        }
        if (tipo.equalsIgnoreCase("m")) {
            System.out.println("Usted es un Metamorfomago para volar solo necesita su poder.");
        }
        if (tipo.equalsIgnoreCase("e")) {
            System.out.println("Usted es un mago Normal para volar necesita de su escoba de modelo Nimbus 2000.");
        }
    }

    public static void AgregarEstudiante(String nombre, String apellido, String edad, String varita,
            String casa, String Tipo_de_mago) {
        String ubicacion = "profesor.txt";
        try {
            FileWriter archivo = new FileWriter(ubicacion, true);

//        for( int i = 0;i <ncurso.length();i++){
//            escritura.write(ncurso.charAt(i));
//            escritura.w
//        }
            PrintWriter linea = new PrintWriter(archivo, true);
            linea.println(nombre + "," + apellido + "," + edad + "," + varita + "," + casa + ","
                    + Tipo_de_mago);
            linea.close();
            archivo.close();
        } catch (Exception e) {
            System.out.println("Error con el archivo");
            System.out.println(e);
        }
    }

}
