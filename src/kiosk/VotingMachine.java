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
    
    private Signature signature;
    private ActivationCard card;
    
    public VotingMachine(ActivationCard card){
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
        
        
        if(this.active) throw new IllegalStateException("Machine already active");
           
        if(validService.validate(this.card)){
            this.card = card;
            this.active = true;            
        }
    }
    
    public boolean canVote() { 
        return true;
    }
    
    public void vote(Vote vote) throws IllegalStateException {
        
        validService.deactivate(this.card);
        this.active = false;
    }
    
    public void sendReceipt(MailAddress address) throws IllegalStateException { 
        mailService.send(address, this.signature);
    }
}
