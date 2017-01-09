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
final public class IrisScan {
    private final byte[] iris;
    
    public IrisScan(byte[] iris) {
        this.iris = iris;
    }
    
    public byte[] getSignature() {
        return iris;
    }

    @Override
    public String toString() {
        return "{" +
        "iris='" + iris + '\'' +
        '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IrisScan irisScan = (IrisScan) o;
        return iris.equals(irisScan.iris);
    }

    @Override
    public int hashCode() {
        return iris.hashCode();
    }
}
