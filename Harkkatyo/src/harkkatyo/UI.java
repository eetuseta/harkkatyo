//Viewer class jossa tapahtuu kaikki kommunikointi käyttäjän kanssa

package harkkatyo;

import java.util.Scanner;

public class UI {
    private static Scanner lukija = new Scanner(System.in);
    
    private Kauppa kauppa;
    private String haluttulevy;
    
    //KONSTRUKTORIT
    //public UI (){}
    
    public UI (Kauppa kauppa){
        this.kauppa=kauppa;
    }
    //METODIT
    
    public String Aloitalevykauppa(){
        System.out.println("Myyjä kysyy: Minkä levyn haluat?");
        haluttulevy=lukija.next();
        while (kauppa.getOnkolevya(haluttulevy).equals("Ei oo.")){
            System.out.println("Myyjä sanoo: PÖH! Ei me ny ihan mitä vaan sunnuntaiartisteja pidetä hyllyillä notkumassa");
            System.out.println("Myyjä sanoo: Kysyppä jotain muuta: ");
            haluttulevy = lukija.next();
        }
        if ("exit".equals(haluttulevy)){
            return haluttulevy;
        }
        else {
            String vastaus = kauppa.getOnkolevya(haluttulevy);
            System.out.println("Myyjä sanoo: Tottakai meillä on "+vastaus+"! Minkälaiseksi levykaupaksi meitä luulet?");
            System.out.println("Myyjä sanoo: Menehän nyt siitä matkoihisi");
            return "exit";
        }
        
    }
    
}
