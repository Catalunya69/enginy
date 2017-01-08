/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Roger
 */
final public class Signature {
    private final byte[] sig;
    
    public Signature(byte[] sig) {
        this.sig = sig;
    }
    
    public byte[] getSignature() {
        return sig;
    }

    @Override
    public String toString() {
        return "{" +
        "sig='" + sig + '\'' +
        '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Signature signature = (Signature) o;
        return sig.equals(signature.sig);
    }

    @Override
    public int hashCode() {
        return sig.hashCode();
    }
}
