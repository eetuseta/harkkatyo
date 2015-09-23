/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harkkatyo;
/**
 *
 * @author jaakk_000
 */
public class Lompakko {
    private double rahamaara;
    
    //konstruktorit
    public Lompakko(){
            }
    public Lompakko(double rahamaara){
        this.rahamaara=rahamaara;
    }
    
    //metodit
    public void setRaha(double rahamaara){
        this.rahamaara=rahamaara;
    }
    public double getRahamaara(){
        return rahamaara;
    }
    public void lisaa(double pano){
        rahamaara=rahamaara+pano;
    }
    boolean vahenna(double otto){
        if (otto>rahamaara){
            System.out.println("Ei ole mistä ottaa, sori...");
            return false;
    }
        else {
            rahamaara=rahamaara-otto;
            return true;
                    } 
}
}

    

