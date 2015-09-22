/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harkkatyo;
import java.util.Scanner;
/**
 *
 * @author jaakk_000
 */
public class UI {
    static Scanner lukija = new Scanner(System.in);
    
    private Kauppa kauppa;
    String haluttulevy;
    
    //Metodit
    void Kauppa (Kauppa kauppa){
        this.kauppa=kauppa;
    }
    
    public void Aloitalevykauppa(){
        System.out.println("Minkä levyn haluat: ");
        haluttulevy=lukija.next();
        kauppa.getOnkolevya(haluttulevy);
    }

}
