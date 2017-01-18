package data;

import data.Vote;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Roger
 */
public class VoteTest {
    private Vote voteA,voteB,voteC;
            
    @Before
    public void setUp() {
        voteA = new Vote("votoA");
        voteB = new Vote("votoB");
        voteC = new Vote("votoA");
    }
    @Test
    public void votosIguales(){  
        assertTrue("Comprobando si dos votos son iguales con equals",voteA.equals(voteC));  
        assertEquals("Comprobando si dos votos son iguales con hashCode",voteA.hashCode(),voteC.hashCode()); 
    }
    
    @Test
    public void votosDistintosEquals(){  
        assertFalse("Comprobando si dos votos son distintos con equals",voteA.equals(voteB));  
    }
    
    @Test
    public void votosDistintosHash(){    
        assertNotEquals("Comprobando si dos votos son distintos con hashCode",voteA.hashCode(),voteB.hashCode()); 

    }

   

}
