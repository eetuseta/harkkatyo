/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jaakk_000
 */
public class Maksukortti {
    private int pin;
    private Pankkitili tili;
    private double maksu;
    
    public Maksukortti(int pin){
        this.pin=pin;
    }
    public int getPin(){
        return pin;
    }
    public void setTili(Pankkitili tili){
        this.tili=tili;        
    }
    public boolean maksa(double maksu){
        if (maksu<=tili.getRahamaara()){
            tili.vahenna(maksu);
            return true;
        }
        else{
            System.out.println("Tilillä ei ole katetta.");
            return false;
        }
    }
}
