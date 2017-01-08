/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import data.MailAddress;
import data.Vote;
import services.ValidationService;

/**
 *
 * @author Roger
 */
public class VotingMachine {
    
    public VotingMachine(){
        
    }
    
    public void setValidationService(ValidationService validationService) {
        
    }
    
    public void activateEmission(ActivationCard card) throws IllegalStateException { 
        
    }
    
    public boolean canVote() { 
        return true;
    }
    
    public void vote(Vote vote) throws IllegalStateException {
    }
    
    public void sendReceipt(MailAddress address) throws IllegalStateException { 
    }
}
