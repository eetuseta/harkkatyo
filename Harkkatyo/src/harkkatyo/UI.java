//Viewer class jossa tapahtuu kaikki kommunikointi käyttäjän kanssa
package harkkatyo;

import java.util.*;
import javax.swing.*;

public class UI {

    private static Scanner lukija = new Scanner(System.in);

    private Kauppa kauppa;
    private String haluttulevy;
    private boolean pysylevynostossa;
    List<Levy> vastaus;

    //KONSTRUKTORIT
    //public UI (){}
    public UI(Kauppa kauppa) {
        this.kauppa = kauppa;
    }

    //METODIT
    public String Forlauseke(List<Levy> vastaus) {
        String listaus = "Löytyi itseasiassa useampikin:";
        for (Levy albumi : vastaus) {
            listaus = listaus + "\n" + albumi;
        }
        return listaus;
    }

    public String Aloitalevykauppa() {
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

        switch (valitsin) {

            case 1: //Aloitusvalitsimen

                haluttulevy = JOptionPane.showInputDialog("Myyjä kysyy: Mitä artistia etsit?");
                while (kauppa.getOnkolevya(haluttulevy) == null && !haluttulevy.equals("palaa")
                        && !haluttulevy.equals("exit")) {
                    JOptionPane.showMessageDialog(null, "Myyjä sanoo: PÖH! Ei me ny ihan mitä vaan "
                            + "sunnuntaiartisteja pidetä hyllyillä notkumassa");
                    haluttulevy = JOptionPane.showInputDialog("Myyjä sanoo: Kysyppä jotain muuta: ");
                    if (haluttulevy.equals("palaa") || haluttulevy.equals("exit")) {
                        break;
                    } else {
                        do {
                            vastaus = kauppa.getOnkolevya(haluttulevy);
                            pysylevynostossa = true;

                            System.out.println(vastaus);
                            String levynostovalitsin = JOptionPane.showInputDialog("Myyjä sanoo: Kyllähän meiltä löytyy!\n"
                                    + Forlauseke(vastaus)
                                    + "! \nHaluaisitko ostaa tämän?\n"
                                    + "\n1 Osta levy."
                                    + "\n2 Tarkista paljon lompakossasi on varaa."
                                    + "\n3 Palaa takaisin.");
                            int valitsin2 = Integer.parseInt(levynostovalitsin);
                            switch (valitsin2) {

                                case 1: //Levynostovalitsimen
                                    String ostettavalevy;
                                    int ostettavanhinta = 0;
                                    ostettavalevy = JOptionPane.showInputDialog("Myyja sanoo: Minkä levyn haluat?\n"
                                            + Forlauseke(vastaus) + "/n");
                                    for (Levy oikea : vastaus) {
                                        if (ostettavalevy == oikea.levynNimi) {
                                            ostettavanhinta = oikea.hinta;
                                        }
                                    }
                                    if (kauppa.asiakas.maksaLevy(ostettavanhinta) == true);
                                    JOptionPane.showMessageDialog(null, "Myyja sanoo: Oleppa hyvä!"
                                            + "\n\nLompakkoosi jäi vielä " + kauppa.lompakko.getRahamaara() + "euroa");

                                    pysylevynostossa = true;
                                    break;

                                case 2: //Levynostovalitsimen
                                    JOptionPane.showMessageDialog(null, "Lompakossasi on " + kauppa.lompakko.getRahamaara() + "euroa .");
                                    pysylevynostossa = true;

                                case 3://Levynostovalitsimen
                                    break;
                            }
                        } while (pysylevynostossa == true);
                    }
                }
                break;

            case 2: //Aloitusvalitsin
                String selaus = JOptionPane.showInputDialog("Miltä kohdalta selataan? (A-Z)");
                

                JOptionPane.showMessageDialog(null, kauppa.asiakas.selaaLevja(selaus));
                break;

            case 3: //Aloitusvalitsin
                return "exit";

        }
    
    
    return haluttulevy ;

}

public void lopetus() {
        JOptionPane.showMessageDialog(null, "Poistuit levykaupasta, "
                + "lompakkoosi jäi " + kauppa.lompakko.getRahamaara() + "euroa"
                + " ja kaupan kassaan jäi " + kauppa.myyja.kassa.getRahaakassassa() + "euroa.");
    }
}
