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
        /*while (!aloitus.equals("1")||!aloitus.equals("2")||!aloitus.equals("3")||
                !aloitus.equals("exit")||!aloitus.equals("palaa")){
            if (aloitus.equals("exit") || !aloitus.equals("palaa")){
        return aloitus;    
        }
        }*/
        valitsin = Integer.parseInt(aloitus);
 
        switch (valitsin){ 
            
        case 1: //Aloitusvalitsimen
            
        haluttulevy = JOptionPane.showInputDialog("Myyjä kysyy: Mitä artistia etsit?");        
        while (kauppa.getOnkolevya(haluttulevy).equals("Ei oo.") && !haluttulevy.equals("palaa") && !haluttulevy.equals("exit")){
            JOptionPane.showMessageDialog(null, "Myyjä sanoo: PÖH! Ei me ny ihan mitä vaan "
                    + "sunnuntaiartisteja pidetä hyllyillä notkumassa");
            haluttulevy = JOptionPane.showInputDialog("Myyjä sanoo: Kysyppä jotain muuta: ");            
            }
        if (haluttulevy.equals("palaa") || haluttulevy.equals("exit")){
            break;
        }
        else {
            String vastaus = kauppa.getOnkolevya(haluttulevy);           
            String levynostovalitsin = JOptionPane.showInputDialog("Myyjä sanoo: Tottakai meillä on\n"
                    +vastaus+"! \nMinkälaiseksi levykaupaksi meitä luulet?\n"
                    + "\n1 Osta tämä levy."
                    + "\n2 Tarkista paljon lompakossasi on varaa."
                    + "\n3 Palaa takaisin.");
            int valitsin2 = Integer.parseInt(levynostovalitsin); 
                switch (valitsin2){
                    
                    case 1: //Levynostovalitsimen
                    JOptionPane.showMessageDialog(null, "OSTOTAPAHTUMA");
                    break;
                        
                    case 2: //Levynostovalitsimen
                    JOptionPane.showMessageDialog(null, "LOMPAKON TILANNE");
                    break;
                        
                    case 3://Levynostovalitsimen
                    break;       
                }
            break;
        }
            case 2: //Aloitusvalitsin
                
                JOptionPane.showMessageDialog(null, "Levyhyllyssä on:\n----------------------------\n");
            return haluttulevy;
                
            case 3: //Aloitusvalitsin
                return "exit";
            
        }
        return haluttulevy;
    }
}
