/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

import java.util.Comparator;

/**
 *
 * @author IYAC
 */
public abstract class Ordenar implements Comparator {

    public static Comparator<Estudiante> EstudiantePorNombre = new Comparator<Estudiante>() {

        public int compare(Estudiante e1, Estudiante e2) {
            if(e1.nombre.compareToIgnoreCase(e2.nombre) == 0) {            
                return e1.nombre.compareTo(e2.nombre);
            } else {
                return e1.nombre.compareToIgnoreCase(e2.nombre);
            }
        }};
    

    public static Comparator<Estudiante> EstudiantePorEdad = new Comparator<Estudiante>() {

        public int compare(Estudiante e, Estudiante e1) {
            if (e.edad == e1.edad) {
                return 0;
            } else if (e.edad > e1.edad) {
                return 1;
            } else {
                return -1;
            }
        }
    };
    
    
    public static Comparator<Estudiante> EstudiantePorMR = new Comparator<Estudiante>() {

        public int compare(Estudiante e, Estudiante e1) {
            if (e.MateriasRegistradas == e1.MateriasRegistradas) {
                return 0;
            } else if (e.MateriasRegistradas > e1.MateriasRegistradas) {
                return 1;
            } else {
                return -1;
            }
        }
    };
    
    

}
