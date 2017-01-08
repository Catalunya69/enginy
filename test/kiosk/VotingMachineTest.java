/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import data.MailAddress;
import data.Signature;
import data.Vote;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import services.*;

/**
 *
 * @author Roger
 */
public class VotingMachineTest {
    
    private ValidationService vaService;
    private MailerService maService;
    private SignatureService siService;
    private VotePrinter voPrinter;
    private VotesDB voDB;
    
    private static class ValidationServiceDouble implements ValidationService{
        @Override
        public boolean validate(ActivationCard card){
            return true;
        }
        @Override
        public void deactivate(ActivationCard card){
            card.erase();
        }
    }
    
    private static class MailerServiceDouble implements MailerService{
        @Override
        public void send(MailAddress address, Signature signature){
            //Enviar Mensage
        }
    }
    
    private static class SignatureServiceDouble implements SignatureService{
        @Override
        public Signature sign(Vote vote){
            return new Signature(vote.getOption().getBytes());
        }
    }
    private static class VotePrinterDouble implements VotePrinter{
        @Override
        public void print(Vote vote){
            // Imprimir voto
        }
    }
    private static class VotesDBDouble implements VotesDB{
        private List<Vote> votes = new ArrayList();
        
        @Override
        public void registerVote(Vote vote){
            votes.add(vote);
        }
        @Override
        public List<Vote> getVotes(){
            return votes;
        }
    }
    
    
    
    
    @Before
    public void setUp() {
        vaService = new ValidationServiceDouble();
        maService = new MailerServiceDouble();
        siService = new SignatureServiceDouble();
        voPrinter = new VotePrinterDouble();
        voDB = new VotesDBDouble();
    }
    
    @Test
    public void votarAntes(){        
        VotingMachine test = new VotingMachine();
        test.setValidationService(vaService);
        test.setMailerService(maService);
        test.setSignatureService(siService);
        test.setVotePrinter(voPrinter);
        test.setVotesDB(voDB);
        
        ActivationCard card = new ActivationCard("code");
        Vote vote = new Vote("Voto");
        
        assertFalse("Comprobando si no se puede votar antes de activar targeta", test.canVote());
        
        test.activateEmission(card);
        
        
        if(test.canVote()){
            test.vote(vote);
            MailAddress mail = new MailAddress("mail@mail.com");
            test.sendReceipt(mail);
            
        }
    }
    
    @Test
    public void votarDespues(){

        VotingMachine test = new VotingMachine();
        test.setValidationService(vaService);
        test.setMailerService(maService);
        test.setSignatureService(siService);
        test.setVotePrinter(voPrinter);
        test.setVotesDB(voDB);
        
        ActivationCard card = new ActivationCard("code");
        Vote vote = new Vote("Voto");

        test.activateEmission(card);
        assertTrue("Comprobando si se puede votar despues de activar targeta", test.canVote());
        
        if(test.canVote()){
            test.vote(vote);
            MailAddress mail = new MailAddress("mail@mail.com");
            test.sendReceipt(mail);
            
        }
    }
    
}
