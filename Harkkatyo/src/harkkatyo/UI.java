//Viewer class jossa tapahtuu kaikki kommunikointi käyttäjän kanssa

package harkkatyo;

import java.util.Scanner;
import javax.swing.*;

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
        int valitsin;
        String aloitus = JOptionPane.showInputDialog("Ohjelma loppuu kirjoittamalla 'exit', ja voit palata "
                + "takaisin kirjoittamalla 'palaa'.\n\nAstuit sisään levykauppaan, "
                + "haluatko kysyä myyjältä artistia vai kävellä ulos? "
                + "\n1 Kysy myyjältä artistia."
                + "\n2 Selaa levyjä hyllystä."
                + "\n3 Kävele ulos.\n");
        valitsin = Integer.parseInt(aloitus);
        switch (valitsin){
            
            case 1:
        haluttulevy = JOptionPane.showInputDialog("Myyjä kysyy: Mitä artistia etsit?");
        
        while (kauppa.getOnkolevya(haluttulevy).equals("Ei oo.") && !haluttulevy.equals("exit")){
            JOptionPane.showMessageDialog(null, "Myyjä sanoo: PÖH! Ei me ny ihan mitä vaan "
                    + "sunnuntaiartisteja pidetä hyllyillä notkumassa");
            haluttulevy = JOptionPane.showInputDialog("Myyjä sanoo: Kysyppä jotain muuta: ");
            
            }
        if (haluttulevy.equals("exit")){
            return haluttulevy;
        }
        else {
            String vastaus = kauppa.getOnkolevya(haluttulevy);
            JOptionPane.showMessageDialog(null, "Myyjä sanoo: Tottakai meillä on "
                    +vastaus+"! Minkälaiseksi levykaupaksi meitä luulet?");
            break;
        }
            case 2:
                
                JOptionPane.showMessageDialog(null, "Levyhyllyssä on:\n----------------------------\n");
            return haluttulevy;
                
            case 3:
                return "exit";
            
        }
        return haluttulevy;
    }
}
