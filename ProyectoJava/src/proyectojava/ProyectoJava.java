/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import proyectojava.VerificarUsuario.Verificar_Usuario;

/**
 * /**
 *
 * @author Mi compu
 */
public class ProyectoJava {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("Bievenido al sistema de registros de Hogwarts");
        boolean band = false;
        String usuario = "";
        String contraseña;
        while (band == false) {
            System.out.println("");
            System.out.print("Ingrese su usuario: ");
            usuario = sc.nextLine();
            System.out.print("Ingrese su contraseña: ");
            contraseña = sc.nextLine();
            System.out.println("");
            band = Verificar_Usuario.VerificarUsuario(usuario, contraseña);
        }

    }

}
