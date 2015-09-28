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
    private int rahamaara=100;
    
    //konstruktorit
    public Lompakko(){
            }
    public Lompakko(int rahamaara){
        this.rahamaara=rahamaara;
    }
    
    //metodit
    public void setRaha(int rahamaara){
        this.rahamaara=rahamaara;
    }
    public int getRahamaara(){
        return rahamaara;
    }
    public void lisaa(int pano){
        rahamaara=rahamaara+pano;
    }
    boolean vahenna(int otto){
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

    

