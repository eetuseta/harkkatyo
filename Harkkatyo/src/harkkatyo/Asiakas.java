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

    static Scanner lukija = new Scanner(System.in);

    public Asiakas() {

    }
    //Myyja myyja = new Myyja();
    public String levy;

    public boolean onkoLevya(String levy) {
        if (myyja.getOnkolevya(levy) == true ){
            System.out.println("kiitos, ostanpa sen pois");
            //kiitos, ostanpa sen pois
            return true;
        }
        else (myyja.getOnkolevya(levy) == false){
        
        System.out.println("voi räkä.");
        return false;
        // voi rähmä
    }
        //tehdään kysely myyjälle. löytyykö levyä x
        //System.out.println("Katsot ympärillesi hämmentyneenä ja käännyt myyjän puoleen.");
        //System.out.println("Hei, onko teillä: " + lukija.next + "levyä?" );

    }

    //selaa levyjä kirjaimen "d" kohdalta
}
