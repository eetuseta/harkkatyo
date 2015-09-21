/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jaakk_000
 */
public class Pankkitili {
    private double rahamaara;
    
    //konstruktorit
    public Pankkitili(){
            }
    public Pankkitili(double rahamaara){
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
            System.out.println("tilillä ei ole katetta.");
            return false;            
        }
        else {
            rahamaara=rahamaara-otto;
            return true;
                    } 
}
}

    

