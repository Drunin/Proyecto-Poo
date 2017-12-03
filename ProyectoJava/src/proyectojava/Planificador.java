/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author IYAC
 */
public class Planificador {

    static ArrayList A_profesores = new ArrayList();
    static ArrayList A_estudiantes = new ArrayList();

    public static void menu_planificador() throws IOException {
        Scanner sc = new Scanner(System.in);
        String opcion;
        int opc = 0;
        boolean flag = false;
        while (flag == false) {
            System.out.println("");
            System.out.println("**************************************************");
            System.out.println("1. Crear Curso");
            System.out.println("2. Crear Profesor");
            System.out.println("3. Crear Estudiante");
            System.out.println("4. Ver Horarios Planificados");
            System.out.println("5. Listado de estudiantes");
            System.out.println("**************************************************");
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
                if (opc < 0 || opc > 5) {
                    System.out.println("Su ingreso está fuera del rango de opciones. Por favor intente nuevamente");
                    flag = false;
                }
            }
        }//fin de la validación de ingreso 
        if (opc == 1) {
            CrearCurso();
        }
        if (opc == 2) {
            CrearProfesor();
        }
        if (opc == 3) {
            CrearEstudiante();
        }

    }

    public static void CrearCurso() {
        boolean flag = false;
        String opcion;
        int opc = 0;
        String[] MateriasGenerales = {"Pociones", "Defensa contra las artes oscuras", "Adivinación", "Astronomía",
            "Historia de la Magia", "Herbología", "Encantamiento", "Vuelo"};
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("******* CREAR CURSO *******");
        while (flag == false) {
            System.out.println("         MATERIAS");
            for (int i = 0; i < MateriasGenerales.length; i++) {
                System.out.println(i + 1 + ". " + MateriasGenerales[i]);
            }
            System.out.print("Elija una materia del listado de materias: ");
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
                if (opc < 0 || opc > MateriasGenerales.length) {
                    System.out.println("Su ingreso está fuera del rango de opciones. Por favor intente nuevamente");
                    flag = false;
                }
            }
        }//find el while

        //Falta el profesor
    }

    public static void CrearProfesor() throws IOException {
        String animal = null;
        String pocion = null;
        String deporte = null;
        String hechizo = null;
        String casa = "";
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        int edad = 0;
        System.out.println("");
        System.out.println("******* Crear Profesor *******");
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese apellido: ");
        String apellido = sc.nextLine();
        while (flag == false) { //Inicio ingreso edad
            System.out.print("Ingrese edad: ");
            flag = true;
            String cadena_edad = sc.nextLine();
            try {
                edad = Integer.parseInt(cadena_edad);
            } catch (Exception e) {
                System.out.println("");
                System.out.println("Error de ingreso. Por favor intente nuevamente.");
                flag = false;
            }
        } //Final ingreso edad 
        System.out.print("Ingrese varita: ");
        String varita = sc.nextLine();
        flag = false;
        while (flag == false) {
            System.out.print("Ingrese casa: ");
            casa = sc.nextLine();
            flag = verificarCasa(casa);
        }
        System.out.println("");
        System.out.print("Fecha de ingreso (dd/mm/aaaa): ");
        String fecha_ingreso = sc.nextLine();
        String tipomyb = tipo_mago();
        if (tipomyb.equalsIgnoreCase("A")) {
            String anihechi = Animago();
            String[] Lanihechi = anihechi.split("-");
            animal = Lanihechi[0];
            hechizo = Lanihechi[1];
        } else {
            if (tipomyb.equalsIgnoreCase("M")) {
                pocion = Metamorfomago();
            } else {
                deporte = Estandar();
            }
        }
        //Confirmo si desea guardar los datos
        int g = guardardatos();
        if (g == 1) {
            //CReo el profesor
            Profesor p = new Profesor(nombre, apellido, edad, casa, varita, tipomyb, animal, hechizo, pocion, deporte, fecha_ingreso);
            A_profesores.add(p);
            System.out.println("Sus datos se han guardado correctamente");
            String ruta = "profesores.txt";
            File archivo = new File(ruta);
            if (archivo.exists()) {
                FileWriter bw = new FileWriter(archivo, true);
                String x = System.getProperty("line.separator");
                bw.write(x + "" + nombre + "," + apellido + "," + edad + "," + varita + "," + fecha_ingreso + "," + tipomyb + "," + animal + "," + hechizo + "," + pocion + "," + deporte);
                bw.close();
                Planificador.menu_planificador();
            } else {
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(nombre + "," + apellido + "," + edad + "," + varita + "," + fecha_ingreso + "," + tipomyb + "," + animal + "," + hechizo + "," + pocion + "," + deporte);
                bw.close();
                Planificador.menu_planificador();
            }
        } else {
            Planificador.menu_planificador();
        }

    }

    public static void CrearEstudiante() throws IOException {
        System.out.println("");
        boolean flag = false;
        String casa = "";
        int edad = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("/** CREAR ESTUDIANTE **/");
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese apellido: ");
        String apellido = sc.nextLine();
        while (flag == false) { //Inicio ingreso edad
            System.out.print("Ingrese edad: ");
            flag = true;
            String cadena_edad = sc.nextLine();
            try {
                edad = Integer.parseInt(cadena_edad);
            } catch (Exception e) {
                System.out.println("");
                System.out.println("Error de ingreso. Por favor intente nuevamente.");
                flag = false;
            }
        } //Final ingreso edad 
        System.out.print("Ingrese varita: ");
        String varita = sc.nextLine();
        flag = false;
        while (flag == false) {
            System.out.print("Ingrese casa: ");
            casa = sc.nextLine();
            flag = verificarCasa(casa);
        }
        String tipomyb = tipo_mago();
        //Crear el estudiante con todos los datos almacenados
        int g = guardardatos();
        if (g == 1) {
            //CReo el profesor
            Estudiante e = new Estudiante(nombre, apellido, edad, casa, varita, tipomyb);
            A_estudiantes.add(e);
            System.out.println("Sus datos se han guardado correctamente");
            String ruta = "estudiantes.txt";
            File archivo = new File(ruta);
            if (archivo.exists()) {
                FileWriter bw = new FileWriter(archivo, true);
                String x = System.getProperty("line.separator");
                bw.write(x + "" + nombre + "," + apellido + "," + edad + "," + varita + "," + casa + "," + tipomyb);
                bw.close();
                Planificador.menu_planificador();
            } else {
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(nombre + "," + apellido + "," + edad + "," + varita + "," + casa + "," + tipomyb);
                bw.close();
                Planificador.menu_planificador();
            }
        } else {
            Planificador.menu_planificador();
        }

    }

    public static int guardardatos() {
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        String resp = "";
        while (flag == false) {
            System.out.print("¿Desea guardar los datos? S/N: ");
            resp = sc.nextLine();
            flag = true;
            if (resp.equalsIgnoreCase("s")) {
                return 1;
            } else {
                if (resp.equalsIgnoreCase("N")) {
                    return 2;
                } else {
                    System.out.println("Error de ingreso. Por favor intente nuevamente.");
                    System.out.println("");
                    flag = false;
                }
            }
        }
        return 0;
    }

    public static String tipo_mago() {
        int itipo = 0;
        String tipomyb = "";
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        String[] tiposmyb = {"ANIMAGO", "METAMORFOMAGO", "ESTANDAR"};
        flag = false;
        while (flag == false) {
            System.out.println("Tipos de Magos/Brujas");
            for (int j = 0; j < tiposmyb.length; j++) {
                System.out.println(j + 1 + ". " + tiposmyb[j]);
            }
            System.out.print("Elija el tipo de mago/bruja que es: ");
            String str_tipo = sc.nextLine();
            flag = true;
            try {
                itipo = Integer.parseInt(str_tipo);
            } catch (Exception e) {
                System.out.println("");
                System.out.println("Error de ingreso. Por favor intente nuevamente.");
                flag = false;
            }
            if (flag == true) {
                if (itipo < 0 || itipo > 3) {
                    System.out.println("Su ingreso está fuera del rango de opciones. Por favor intente nuevamente");
                    flag = false;
                }
            }
        }
        if (itipo == 1) { //Animago
            tipomyb = "A";
        }
        if (itipo == 2) { //Metamorfomago
            tipomyb = "M";
        }
        if (itipo == 3) { //Estandar 
            tipomyb = "E";
        }

        return tipomyb;
    }

    public static String Animago() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el animal en el que puede convertirse: ");
        String animal = sc.nextLine();
        System.out.print("Ingrese el hechizo que utiliza: ");
        String hechizo = sc.nextLine();
        String ani_hechizo = animal + "-" + hechizo;
        return ani_hechizo;
    }

    public static String Metamorfomago() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la poción que utiliza: ");
        String pocion = sc.nextLine();
        return pocion;
    }

    public static String Estandar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese su deporte favorito: ");
        String deporte = sc.nextLine();
        return deporte;
    }

    public static boolean verificarCasa(String casa) {
        //busco si la casa esta en la lista de tipos
        boolean flag = false;
        String[] tipo_casa = {"Griffindor", "Ravenclaw", "Hufflepuff", "Slytherin"};
        for (int i = 0; i < tipo_casa.length; i++) {
            if (casa.equalsIgnoreCase(tipo_casa[i])) {
                return true;
            }
        }
        System.out.println("");
        System.out.println("La casa que ingreso no se encuentra en la lista!");
        System.out.println("TIPOS DISPONIBLES:");
        for (int i = 0; i < tipo_casa.length; i++) {
            System.out.print(tipo_casa[i] + "    ");
        }
        System.out.println("");
        return false;
    }

} //Llave final de la clase planificadoe
