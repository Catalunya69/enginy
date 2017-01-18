/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import data.MailAddress;
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
public class MailAddressTest {
    private MailAddress mailA,mailB,mailC;
            
    @Before
    public void setUp() {
        mailA = new MailAddress("mail@A.test");
        mailB = new MailAddress("mail@B.test");
        mailC = new MailAddress("mail@A.test");
    }
    
    @Test
    public void mailsIguales(){  
        assertTrue("Comprobando si dos mails son iguales con equals",mailA.equals(mailC));  
        assertEquals("Comprobando si dos mails son iguales con hashCode",mailA.hashCode(),mailC.hashCode()); 
    }
    
    @Test
    public void mailsDistintosEquals(){  
        assertFalse("Comprobando si dos mails son distintos con equals",mailA.equals(mailB));  
    }
    
    @Test
    public void mailsDistintosHash(){    
        assertNotEquals("Comprobando si dos mails son distintos con hashCode",mailA.hashCode(),mailB.hashCode()); 

    }
}
