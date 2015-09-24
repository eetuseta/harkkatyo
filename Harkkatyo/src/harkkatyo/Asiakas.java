package harkkatyo;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tony
 */
public class Asiakas {

    private Myyja myyja;
    private Lompakko lompakko;
    public int hinta;

    public String levy;//teksti
    static Scanner lukija = new Scanner(System.in);

    public Asiakas() {

    }

    public void Myyja(Myyja myyja) {
        this.myyja = myyja;
    }
    
    public String onkoLevya (String levy){
        myyja.getOnkolevya(levy);
        return levy;
    }
    /*public boolean ostaLevy (String levy){
        if(myyja.getOnkolevya(levy)){
            return true;
        }
        else{
            return false;}
        
        }*/
   public boolean maksaLevy(int rahamaara){
       if(lompakko.getRahamaara() > hinta){
           return true;
       }
       else{ return false;}
   }
        
}

    /*boolean onkoLevya(String levy) {
     if (myyja.getOnkolevya(levy) == true) {
     System.out.println("kiitos, ostanpa sen pois");
     //kiitos, ostanpa sen pois
     return true;
     } else {
     (myyja.getOnkolevya(levy) == false)
     {

     System.out.println("voi räkä.");
     return false;
     // voi rähmä
     }*/
        //tehdään kysely myyjälle. löytyykö levyä x
    //System.out.println("Katsot ympärillesi hämmentyneenä ja käännyt myyjän puoleen.");
    //System.out.println("Hei, onko teillä: " + lukija.next + "levyä?" );


//selaa levyjä kirjaimen "d" kohdalta

