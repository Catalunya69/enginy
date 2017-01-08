/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

/**
 *
 * @author Roger
 */
public class ActivationCard {
    
    private String code;
    private boolean active;
    
    ActivationCard(String code){
        this.code = code;
        this.active = true;
    }
    
    public String getCode(){
        return code;
    }
    
    public boolean isActive() {
        return true;
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
    
}
