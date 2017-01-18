package data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Roger
 */
public class SignatureTest {
    private Signature sigA,sigB,sigC;
            
    @Before
    public void setUp() {
        sigA = new Signature("SigA".getBytes());
        sigB = new Signature("SigB".getBytes());
        sigC = new Signature("SigA".getBytes());
    }
    
    @Test
    public void signatureIguales(){  
        assertTrue("Comprobando si dos signature son iguales con equals",sigA.equals(sigC));  
        assertEquals("Comprobando si dos signature son iguales con hashCode",sigA.hashCode(),sigC.hashCode()); 
    }
    
    @Test
    public void signatureDistintosEquals(){  
        assertFalse("Comprobando si dos signature son distintos con equals",sigA.equals(sigB));  
    }
    
    @Test
    public void signatureDistintosHash(){    
        assertNotEquals("Comprobando si dos signature son distintos con hashCode",sigA.hashCode(),sigB.hashCode()); 

    }
}
