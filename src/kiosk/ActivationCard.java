/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import data.IrisScan;

/**
 *
 * @author Roger
 */
final public class ActivationCard {
    
    private String code;
    private boolean active;
    private IrisScan iris;
    
    public ActivationCard(String code){
        this.code = code;
        this.active = true;
        this.iris = null;
    }
    
    public String getCode(){
        return code;
    }
    
    public boolean isActive() {
        return active;
    }
    
    public void erase() {
        this.code = "";
        this.active = false;
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivationCard card = (ActivationCard) o;
        return code.equals(card.code);
    }
    
    public void setIrisScan(IrisScan iris){
        this.iris = iris;
    }
    
    public IrisScan getIrisScan(){
        return iris;
    }
    
    public boolean isScan(){
        if(this.iris==null){ return false;}else{return true;}
    }
    
}
