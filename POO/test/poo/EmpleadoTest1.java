/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class EmpleadoTest1 {
    private Persona p;
    private Empleado instance;
    
    public EmpleadoTest1() {
        /*Nif: 45000111BNombre: Salim Tieb Mohamedi Sueldo Base: 1000.0Horas Extras: 10Tipo IRPF: 5.0*/
        p=new Persona("Salim","Tieb","Mohamedi",'H',33,"C/ Nueva, 33.");
        //datos caso 1
        instance=new Empleado(p,"45000111B",1000.0,10,5.0,'S',3);
        
        Empleado.setPagoPorHoraExtra(15);
    }

 
   
    /**
     * Test of calcularImporteHorasExtra method, of class Empleado.
     */
    @Test
    public void testCalcularImporteHorasExtra() {
        System.out.println("calcularImporteHorasExtra");
        
        double expResult = 150.0;
        double result = instance.calcularImporteHorasExtra();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of calcularSueldoBruto method, of class Empleado.
     */
    @Test
    public void testCalcularSueldoBruto() {
        System.out.println("calcularSueldoBruto");
        
        double expResult = 1150.0;
        double result = instance.calcularSueldoBruto();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of calcularRetencionIRPF method, of class Empleado.
     */
    @Test
    public void testCalcularRetencionIRPF() {
        System.out.println("calcularRetencionIRPF");
        
        double expResult = 0.0;
        double result = instance.calcularRetencionIRPF();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of calcularSueldoNeto method, of class Empleado.
     */
    @Test
    public void testCalcularSueldoNeto() {
        System.out.println("calcularSueldoNeto");
        
        double expResult = 1150.0;
        double result = instance.calcularSueldoNeto();
        assertEquals(expResult, result, 0.0);

    }

    
    
}
