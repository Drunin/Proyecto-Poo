/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author IYAC
 */
public class VerificarUsuario extends Usuario {

    static class Verificar_Usuario {

        //En este metodo se cargan los datos del usuarios.txt 
        //y se crean las listas de estudiantes y planificador consu respectivo usuario
        public static boolean VerificarUsuario(String usuario, String contraseña) throws FileNotFoundException, IOException {
            String archivo = "usuarios.txt";
            String cadena;
            int tamaño = 0;
            FileReader f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);
            while ((cadena = b.readLine()) != null) {
                tamaño = tamaño + 1;
            }
            String[] Listadeestudiantes = new String[tamaño];
            String[] ListaPlanificador = new String[tamaño];
            String[] ListadeContraseñaE = new String[tamaño];
            String[] ListaContraseñasP = new String[tamaño];
            String[] LCadena;
            b.close();
            int indice_p = 0;
            int indice_e = 0;
            FileReader file = new FileReader(archivo);
            BufferedReader d = new BufferedReader(file);
            while ((cadena = d.readLine()) != null) {
                //Carga cadena 
                LCadena = cadena.split(",");
                if (LCadena[4].equalsIgnoreCase("planificador")) {
                    ListaPlanificador[indice_p] = LCadena[0];
                    ListaContraseñasP[indice_p] = LCadena[1];
                    indice_p++;
                } else {
                    Listadeestudiantes[indice_e] = LCadena[0];
                    ListadeContraseñaE[indice_e] = LCadena[1];
                    indice_e++;
                }
            }
            d.close();
            boolean flag = false;
            //String usuario, String contraseña
            for (int i = 0; i < tamaño; i++) {
                if (usuario.equalsIgnoreCase(Listadeestudiantes[i])) {
                    if (contraseña.equalsIgnoreCase(ListadeContraseñaE[i])) {
                        System.out.println("Ingreso exitoso");
                        //llamo al menu de estudiante
                        System.out.println("");
                        System.out.println("MENÚ DE ESTUDIANTE");
                        Estudiante.menu_estudiante();
                        flag = true;
                        return true;
                    } else {
                        flag = false;
                    }
                }
                if (flag == false) {
                    if (usuario.equalsIgnoreCase(ListaPlanificador[i])) {
                        if (contraseña.equalsIgnoreCase(ListaContraseñasP[i])) {
                            System.out.println("Ingreso exitoso");
                            System.out.println("");
                            //llamo al menu de estudiante
                            System.out.println("MENÚ DE PLANIFICADOR");
                            Planificador.menu_planificador();
                            flag = true;
                            return true;
                        } else {
                            flag = false;
                        }
                    }
                }
            }
            if (flag == false) {
                System.out.println("El usuario o la contraseña no son válidos. Por favor intente otra vez");
                return flag;
            }
            return flag;
        }
    }

}
