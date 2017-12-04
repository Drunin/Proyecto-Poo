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
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author IYAC
 */
public class Planificador {

    static String opcion;
    static String opcionP;
    static String[] MateriasGenerales = {"Pociones", "Defensa contra las artes oscuras", "Adivinación", "Astronomía",
        "Historia de la Magia", "Herbología", "Encantamiento", "Vuelo"};
    static ArrayList A_profesores = new ArrayList();
    static ArrayList A_estudiantes = new ArrayList();
//Se presenta el menu del planificador
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
            System.out.println("6. Salir");
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
                if (opc < 0 || opc > 6) {
                    System.out.println("Su ingreso está fuera del rango de opciones. Por favor intente nuevamente");
                    flag = false;
                }
            }
        }//fin de la validación de ingreso 
        while (opc != 6) {
            if (opc == 1) {
                opc = 6;
                Opcion1Curso();

            }
            if (opc == 2) {
                opc = 6;
                CrearProfesor();
            }
            if (opc == 3) {
                opc = 6;
                CrearEstudiante();
            }
            if (opc == 4)//ver horarios planificado
            {
                opc = 6;
                System.out.println("MATERIAS");
                for (int i = 0; i < 8; i++) {
                    System.out.println(i + 1 + ". " + MateriasGenerales[i]);
                }
                System.out.println("Eliga una materia del listado: ");
                int num = sc.nextInt();
                String materia = MateriasGenerales[num - 1];
                Curso.ObtenerCursoP(materia);
                menu_planificador();

            }
            if (opc == 5) { //Listado de estudiantes
                opc = 6;
                flag = false;
                while (flag == false) {
                    System.out.println("Escoja el tipo de ordenamiento ");
                    System.out.println("1. Por nombre ");
                    System.out.println("2. Por edad ");
                    System.out.println("3. Por Materias Registradas ");
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
                if (A_estudiantes.size() == 0) {
                    System.out.println("No se han creado estudiantes todavia!");
                } else {
                    if (opc == 1) { //por nombre
                        Collections.sort(A_estudiantes, Ordenar.EstudiantePorNombre);
                        System.out.println("Por nombre");
                        for (int i = 0; i < A_estudiantes.size(); i++) {
                            System.out.println(A_estudiantes.get(i));
                        }
                    }
                    if (opc == 2) { //por edad

                        Collections.sort(A_estudiantes, Ordenar.EstudiantePorEdad);
                        System.out.println("Por edad");
                        for (int i = 0; i < A_estudiantes.size(); i++) {
                            System.out.println(A_estudiantes.get(i));
                        }

                    }
                    if (opc == 3) { //por mr
                        Collections.sort(A_estudiantes, Ordenar.EstudiantePorMR);
                        System.out.println("Por Materias Registradas");
                        for (int i = 0; i < A_estudiantes.size(); i++) {
                            System.out.println(A_estudiantes.get(i));
                        }
                    }
                    menu_planificador();
                }
                menu_planificador();

            }
        }
    }
//muestra las materias disponibles para la creacion de un curso
    public static void Opcion1Curso() throws IOException {
        String op;
        Scanner sc = new Scanner(System.in);
        if (Profesor.LineasArchivo() <= 1) {
            System.out.println("No hay profesores registrados, registre uno antes de "
                    + "crear un curso");
            menu_planificador();
        } else {
            System.out.println("MATERIAS");
            for (int i = 0; i < 8; i++) {
                System.out.println(i + 1 + ". " + MateriasGenerales[i]);
            }
            System.out.println("Eliga una materia del listado: ");
            int num = sc.nextInt();
            String materia = MateriasGenerales[num - 1];
            System.out.println("");
            System.out.println("");
            System.out.println("PROFESORES");
            String[] Aprofesores = Profesor.ListaProfesores();
            for (int x = 0; x < Aprofesores.length; x++) {
                System.out.println(x + 1 + ". " + Aprofesores[x]);

            }

            System.out.print("Eliga un profesor del listado de materias: ");
            int numProfesor = sc.nextInt();
            String profesor = Aprofesores[numProfesor - 1];
            System.out.print("");
            String saltoDeLinea = sc.nextLine();
            System.out.print("Ingrese capacidad del curso:");
            String capacidad = sc.nextLine();
            System.out.print("");
            System.out.print("Ingrese el dia:");
            String dia = sc.nextLine();

            System.out.print("Ingrese el horario del curso (hh:mm-hh:mm):  ");
            String horario = sc.nextLine();
            String fecha = dia + "-" + horario;
            boolean flag = Horario.Registrar_Horario(fecha);
            while (flag == false) {
                System.out.print("Ingrese el dia:");
                dia = sc.nextLine();
                System.out.print("Ingrese el horario del curso (hh:mm-hh:mm):  ");
                horario = sc.nextLine();
                fecha = dia + "-" + horario;
                flag = Horario.Registrar_Horario(fecha);
            }
            CrearCurso(materia, profesor, dia, horario, capacidad);
            menu_planificador();
        }
    }
//Permite crear una objeto curso y lo registrar en el curso.txt
    static public void CrearCurso(String materia, String profesor, String dia, String horario, String capacidad) {
        String datoscurso = materia + "," + profesor + "," + dia + "," + horario + "," + capacidad;
        String fecha = dia + "-" + horario;
        Curso.AgregarCurso(datoscurso);
    }
//crea un objeto profesor y llama al metodo registrarprofesor
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
//crea un estudiante y lo agrega a estudiantes.txt con todos los datos necesarios
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
//metodos utilizados por la clase estudiante dependiendo del tipo de mago o hechicero y algunas verificaciones
    //para validar que no se estan ingresando datos erroneos
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
