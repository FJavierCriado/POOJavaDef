/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;


import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class PersonaTest {
    
    public PersonaTest() {
    }
    
 
    @Test
    public void testMayorEdad() {
        System.out.println("mayorEdad");
        Persona instance = new Persona();
        instance.setNombre("Javier");
        instance.setEdad(100);
        boolean expResult = true;
        boolean result = instance.mayorEdad();
        assertEquals(expResult, result);
        try {
            // TODO review the generated test code and remove the default call to fail.
            instance.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(PersonaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
    
}
