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
public class Ejecucion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion;
        String opcionP;
        String[] MateriasGenerales = {"Pociones", "Defensa contra las artes oscuras", "Adivinación", "Astronomía",
            "Historia de la Magia", "Herbología", "Encantamiento", "Vuelo"};
        RollPlanificador planificador = new RollPlanificador();
        while (true) {
            System.out.println("");
            System.out.println("Bievenido al sistema de registros de Hogwarts");
            System.out.println("Indique el el rol que desea escoger ");
            System.out.println("1. Hechizero Planificador");
            System.out.println("2. Estudiante");
            opcion = sc.nextLine();

            while ((opcion.equalsIgnoreCase("1") | opcion.equalsIgnoreCase("2")) == false) {
                System.out.println("Opcion incorrecta, vuelva a elegir");
                opcion = sc.nextLine();
            }
            while (opcion.equalsIgnoreCase("1") == true) {
                System.out.println("Menu de Hechizero planificador");
                System.out.println("1. Crear curso");
                System.out.println("2. Crear Profesor");
                System.out.println("3. Crear Estudiantes");
                System.out.println("4. Ver horarios planificados");
                System.out.println("5. Listado de estudiantes");
                opcionP = sc.nextLine();

                //Crear curso
                if (opcionP.equalsIgnoreCase("1")) {
                    String op;

                    if (Profesor.LineasArchivo() <= 1) {
                        System.out.println("No hay profesores registrados, registre uno antes de "
                                + "crear un curso");
                    } else {
                        System.out.println("MATERIAS");
                        for (int i = 0; i < 8; i++) {
                            System.out.println(i + ". " + MateriasGenerales[i]);
                        }
                        System.out.println("Eliga una materia del listado: ");
                        for (int i = 0; i < 8; i++) {
                            System.out.println(i + "." + MateriasGenerales[i]);
                        }
                        int num = sc.nextInt();
                        String materia = MateriasGenerales[num];

                        System.out.println("PROFESORES");
                        String[] Aprofesores = Profesor.ListaProfesores(materia);
                        for (int x = 0; x < Aprofesores.length; x++) {
                            System.out.println(x + ". " + Aprofesores[x]);

                        }
                        
                        System.out.println("Eliga un profesor del listado de materias");
                        int numProfesor = sc.nextInt();
                        String profesor = Aprofesores[numProfesor];
                        
                        System.out.println("Ingrese capacidad del curso");
                        String capacidad = sc.nextLine();
                        
                        System.out.println("Ingrese el dia: ");
                        String dia = sc.nextLine();
                        
                        System.out.println("Ingrese el horario del curso: ");
                        String horario = sc.nextLine();
                        
                        String horarioI = horario.split("-")[0];
                        String horarioF = horario.split("-")[-1];
                        
                        Horario H = new Horario();
                        while(H.HorarioDisponible(dia, horarioI, horarioF) == false){
                            System.out.println("Horario no disponible ");
                            horario = sc.nextLine();
                        }
                        
                        RollPlanificador.CrearCurso(materia, profesor, dia, horario, capacidad);
                    }
                }
                
                
                if (opcionP.equalsIgnoreCase("2")) {
                    planificador.CrearProfesor();
                }
                
                 if (opcionP.equalsIgnoreCase("3")) {
                    planificador.CrearEstudiante();
                }
                 
                  if (opcionP.equalsIgnoreCase("2")) {
                    System.out.println("MATERIAS");
                        for (int i = 0; i < 8; i++) {
                            System.out.println(i + ". " + MateriasGenerales[i]);
                        }
                        System.out.println("Eliga una materia del listado: ");
                        for (int i = 0; i < 8; i++) {
                            System.out.println(i + "." + MateriasGenerales[i]);
                        }
                        int num = sc.nextInt();
                        String materia = MateriasGenerales[num];
                      
                      planificador.VerHorarios(materia);
                }
            }
        }

    }
}
