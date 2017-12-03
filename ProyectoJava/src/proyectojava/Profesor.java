/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

/**
 *
 * @author IYAC
 */
public class Profesor extends Usuario {
     String fechaingreso;
    public Profesor(String nombre,String apellido,int edad,String casa,String varita, 
            String Tipo_de_mago,String animal,String hechizo, String pocion,String deporte, String fecha_ingreso){
        super.nombre=nombre;
        super.apellido=apellido;
        super.edad=edad;
        super.casa=casa;
        super.varita=varita;
        super.Tipo_de_mago=Tipo_de_mago;
        super.animal=animal;
        super.pocion=pocion;
        super.deporte=deporte;
        super.hechizo=hechizo;
        this.fechaingreso=fecha_ingreso;
                
}}
