/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harkkatyo;

import harkkatyo.Levyt;
import java.util.*;

/**
 *
 * @author jaakk_000
 */
public class Testis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Levyt testi = new Levyt();
        
        
        //TÄMÄ ON TONYN IKIOMA HASHMAP-TESTI
        HashMap<String, String> mappi = new HashMap();
        mappi.put("Kalle", "Anka");
        mappi.put("Petteri", "Punakuono");

        String Nimi = mappi.get("Kalle");
        System.out.println(Nimi);
    }
}
