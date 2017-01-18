/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Roger
 */
public class IrisScanTest {
    private IrisScan irisA,irisB,irisC;
            
    @Before
    public void setUp() {
        irisA = new IrisScan("irisA".getBytes());
        irisB = new IrisScan("irisB".getBytes());
        irisC = new IrisScan("irisA".getBytes());
    }
    
    @Test
    public void signatureIguales(){  
        assertTrue("Comprobando si dos irisScan son iguales con equals",irisA.equals(irisC));  
        assertEquals("Comprobando si dos irisScan son iguales con hashCode",irisA.hashCode(),irisC.hashCode()); 
    }
    
    @Test
    public void signatureDistintosEquals(){  
        assertFalse("Comprobando si dos irisScan son distintos con equals",irisA.equals(irisB));  
    }
    
    @Test
    public void signatureDistintosHash(){    
        assertNotEquals("Comprobando si dos irisScan son distintos con hashCode",irisA.hashCode(),irisB.hashCode()); 

    }
}
