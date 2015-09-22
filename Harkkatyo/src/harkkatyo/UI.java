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
        System.out.println("Myyjä kysyy: Minkä levyn haluat?");
        haluttulevy=lukija.next();
        while (kauppa.getOnkolevya(haluttulevy)==false){
            System.out.println("Myyjä sanoo: PÖH! Ei me ny ihan mitä vaan sunnuntaiartisteja pidetä hyllyillä notkumassa");
            System.out.println("Myyjä sanoo: Kysyppä jotain muuta: ");
            haluttulevy = lukija.next();
        }
            System.out.println("Myyjä sanoo: Tottakai meillä on "+haluttulevy+"! Minkälaiseksi levykaupaksi meitä luulet?");

        {
            System.out.println("Myyjä sanoo: Menehän nyt siitä matkoihisi");
        }
        
    }
    
}
