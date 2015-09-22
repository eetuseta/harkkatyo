//Viewer class jossa tapahtuu kaikki kommunikointi käyttäjän kanssa

package harkkatyo;

import java.util.Scanner;

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
