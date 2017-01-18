/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocks;

import data.IrisScan;
import data.MailAddress;
import data.Signature;
import data.Vote;
import java.util.ArrayList;
import java.util.List;
import kiosk.ActivationCard;
import services.IrisScanner;
import services.MailerService;
import services.SignatureService;
import services.ValidationService;
import services.VotePrinter;
import services.VotesDB;

/**
 *
 * @author Roger
 */
public class Doubles {
    public static class ValidationServiceOkDouble implements ValidationService{
        @Override
        public boolean validate(ActivationCard card){
            return true;
        }
        @Override
        public void deactivate(ActivationCard card){
            System.out.println("Borro");
            card.erase();
        }
    }
    
    public static class ValidationServiceErrorValidateDouble implements ValidationService{
        @Override
        public boolean validate(ActivationCard card){
            return false;
        }
        @Override
        public void deactivate(ActivationCard card){
            card.erase();
        }
    }
    
    public static class ValidationServiceErrorDesactivateDouble implements ValidationService{
        @Override
        public boolean validate(ActivationCard card){
            return true;
        }
        @Override
        public void deactivate(ActivationCard card){ }
    }
    
    public static class ValidationServiceErrorDouble implements ValidationService{
        @Override
        public boolean validate(ActivationCard card){
            return false;
        }
        @Override
        public void deactivate(ActivationCard card){    }
    }
    
    public static class MailerServiceOkDouble implements MailerService{
        @Override
        public void send(MailAddress address, Signature signature){
            System.out.println("Mensaje enviado ( "+address.getAddress()+" , "+signature.getSignature()+")");
        }
    }
    
    public static class SignatureServiceOkDouble implements SignatureService{
        @Override
        public Signature sign(Vote vote){
            return new Signature(vote.getOption().getBytes());
        }
    }
    public static class VotePrinterOkDouble implements VotePrinter{
        @Override
        public void print(Vote vote){
            // Imprimir voto
        }
    }
    public static class VotesDBOkDouble implements VotesDB{
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
    
    public static class IrisScannerOkDouble implements IrisScanner{
        @Override
        public IrisScan scan(){
            String code = "CodeIris";
            return new IrisScan(code.getBytes());
        }
    }
}
