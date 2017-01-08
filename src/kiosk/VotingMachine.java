/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import data.*;
import services.*;

/**
 *
 * @author Roger
 */
public class VotingMachine {
    
    private boolean active;
    private ValidationService validService;
    private VotePrinter votePrinter;
    private VotesDB votesDB;
    private SignatureService sigService;
    private MailerService mailService;
    
    private Vote vote;
    private ActivationCard card;
    
    public VotingMachine(){
        this.card = null;
        this.active = false;
    }
    
    public void setValidationService(ValidationService validationService) {
        this.validService = validationService;
    }
    public void setVotePrinter(VotePrinter votePrinter) {
        this.votePrinter = votePrinter;
    }
    public void setVotesDB(VotesDB votesDB) {
        this.votesDB = votesDB;
    }
    public void setSignatureService(SignatureService sigService) {
        this.sigService = sigService;
    }
    public void setMailerService(MailerService mailService) {
        this.mailService = mailService;
    }
    
    public void activateEmission(ActivationCard card) throws IllegalStateException { 
        
        
        if(this.active) throw new IllegalStateException("No se puede votar");
           
        if(validService.validate(card)){
            this.card = card;
            this.active = true;            
        }
    }
    
    public boolean canVote() { 
        return active;
    }
    
    public void vote(Vote vote) throws IllegalStateException {
        
        if(!canVote()) throw new IllegalStateException("No se puede votar");
        
        votesDB.registerVote(vote);
        votePrinter.print(vote);
        validService.deactivate(this.card);
        this.active = false;
        this.vote = vote;
    }
    
    public void sendReceipt(MailAddress address) throws IllegalStateException { 
        
        if(card == null) throw new IllegalStateException("No se puede votar");
        if(card != null && this.active==true) throw new IllegalStateException("No se ha votado");
        
        mailService.send(address, sigService.sign(vote));
    }
}
