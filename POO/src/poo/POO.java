/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

/**
 *
 * @author usuario
 */
public class POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persona p=new Persona("Javier","Criado","Navarro",'H',25,"C\\ Camino Viejo, 33, 24.");
        Empleado e=new Empleado(p, "43300990P",1000,10,5.0,'N',2);
        Empleado.setPagoPorHoraExtra(30.0);
        System.out.println(e);
    }
    
}
