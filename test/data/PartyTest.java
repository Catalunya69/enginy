/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import data.Party;
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
public class PartyTest {
    private Party partyA,partyB,partyC;
            
    @Before
    public void setUp() {
        partyA = new Party("partyA");
        partyB = new Party("partyB");
        partyC = new Party("partyA");
    }
    
    @Test
    public void votosIguales(){  
        assertTrue("Comprobando si dos votos son iguales con equals",partyA.equals(partyC));  
        assertEquals("Comprobando si dos votos son iguales con hashCode",partyA.hashCode(),partyC.hashCode()); 
    }
    
    @Test
    public void votosDistintosEquals(){  
        assertFalse("Comprobando si dos votos son distintos con equals",partyA.equals(partyB));  
    }
    
    @Test
    public void votosDistintosHash(){    
        assertNotEquals("Comprobando si dos votos son distintos con hashCode",partyA.hashCode(),partyB.hashCode()); 

    }
}