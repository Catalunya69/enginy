/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Roger
 */
public class ActivationCardTest {
    
   @Test
    public void testGetCode(){
        ActivationCard test = new ActivationCard("testCode");        
        assertEquals("Comprobando número de codigo", "testCode",test.getCode());
    }
    
    @Test
    public void testIsActive(){
        ActivationCard test = new ActivationCard("testCode");
        assertTrue("Comprobando si el codigo esta activado", test.isActive());
    }
    
    public void testNoIsActive(){
        ActivationCard test = new ActivationCard("testCode");
        test.erase();
        assertFalse("Comprobando si el codigo esta desactivado", test.isActive());
    }
    
    @Test
    public void testErase(){
        ActivationCard test = new ActivationCard("testCode");
        test.erase();
        assertEquals("Comprobando si el codigo se ha borrado", test.getCode(),"");
    }

    /**
     * Test of equals method, of class ActivationCard.
     */
    @Test
    public void testEquals() {
        ActivationCard test = new ActivationCard("testCode");
        ActivationCard test2 = new ActivationCard("testCode");
       
        assertTrue("Comprobar dos codis son iguals", test.equals(test2));
    }
    
    @Test
    public void testNoEquals() {
        ActivationCard test = new ActivationCard("testCode");
        ActivationCard test2 = new ActivationCard("NoCode");
       
        assertFalse("Comprobar dos codis no son iguals", test.equals(test2));
    }
    
}
