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
    private String selausvalinta;
    private boolean pysyselauksessa;
    private int ostettavanhinta = 0;
    private int valitsin3;



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
        do {
        String aloitus = JOptionPane.showInputDialog("Ohjelma loppuu kirjoittamalla 'exit'."
                + "\n\nAstuit sisään levykauppaan, "
                + "haluatko kysyä myyjältä artistia vai kävellä ulos? "
                + "\n1 Kysy myyjältä artistia."
                + "\n2 Selaa levyjä hyllystä."
                + "\n3 Kävele ulos.\n");
        if (aloitus.equals("exit")){
            return "exit";
        }
        
        valitsin = Integer.parseInt(aloitus);

        switch (valitsin) {

            case 1: //Aloitusvalitsimen
                
                //do {
                haluttulevy = JOptionPane.showInputDialog("Myyjä kysyy: Mitä artistia etsit?");
                while (kauppa.getOnkolevya(haluttulevy) == null && !haluttulevy.equals("palaa")
                        && !haluttulevy.equals("exit")) {
                    JOptionPane.showMessageDialog(null, "Myyjä sanoo: PÖH! Ei me ny ihan mitä vaan "
                            + "sunnuntaiartisteja pidetä hyllyillä notkumassa");
                    }
                    haluttulevy = JOptionPane.showInputDialog("Myyjä sanoo: Kysyppä jotain muuta: ");
                    if (haluttulevy.equals("palaa") || haluttulevy.equals("exit") || haluttulevy == null) {
                        break;
                    } else {
                        do {
                            vastaus = kauppa.getOnkolevya(haluttulevy);
                            pysylevynostossa = true;
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
                                    ostettavalevy = JOptionPane.showInputDialog("Myyja sanoo: Minkä levyn haluat?\n"
                                            + Forlauseke(vastaus) + "/n");
                                    for (Levy oikea : vastaus) {
                                        if (ostettavalevy.equalsIgnoreCase(oikea.levynNimi)) {
                                            ostettavanhinta = oikea.hinta;
                                        }
                                    }
                                    if (kauppa.asiakas.maksaLevy(ostettavanhinta) == true){
                                    JOptionPane.showMessageDialog(null, "Myyja sanoo: Oleppa hyvä!"
                                            + "\n\nLompakkoosi jäi vielä "+ kauppa.lompakko.getRahamaara()+"euroa.");
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, ostettavanhinta);
                                            }
                                    pysylevynostossa = true;
                                    break;

                                case 2: //Levynostovalitsimen
                                    JOptionPane.showMessageDialog(null, "Lompakossasi on " + kauppa.lompakko.getRahamaara() + "euroa .");
                                    pysylevynostossa = true;

                                case 3://Levynostovalitsimen
                                    pysylevynostossa = false;
                                    
                                    break;
                            }
                        } while (pysylevynostossa == true);
                    }
                //}while (!haluttulevy.equals("exit"));
                break;

            case 2: //Aloitusvalitsin
                do {
                String selaus = JOptionPane.showInputDialog("Miltä kohdalta selataan? (A-Z)");
                ArrayList<Levy> selauslista = new ArrayList();
                selauslista = kauppa.asiakas.tulostaLevja(selaus);
                selausvalinta = JOptionPane.showInputDialog(null, kauppa.asiakas.selaaLevja(selaus)+"\n"
                        + "\nKirjoita levy, jonka haluat ostaa\n"
                        + "tai\n"
                        + "2 Selaa muita levyjä\n"
                        + "3 Poistu hyllyjen luota");
                if (!selausvalinta.equals(1) || !selausvalinta.equals(2) || !selausvalinta.equals(3)){
                    for (Levy oikea : selauslista) {
                                        if (selausvalinta.equalsIgnoreCase(oikea.levynNimi)) {
                                            ostettavanhinta = oikea.hinta;
                                        }
                                    }
                                    if (kauppa.asiakas.maksaLevy(ostettavanhinta) == true){
                                    JOptionPane.showMessageDialog(null, "Myyja sanoo: Oleppa hyvä!"
                                            + "\n\nLompakkoosi jäi vielä "+ kauppa.lompakko.getRahamaara()+"euroa.");
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, ostettavanhinta);
                                            }
                                    pysyselauksessa = true;
                                    break;
                    
                }
                else {
                    valitsin3 = Integer.parseInt(selausvalinta);
                }
                switch (valitsin3){
                    case 1:
                        pysyselauksessa = true;
                        break;
                    case 2: 
                        pysyselauksessa = false;
                        break;
                }
                }
                while (pysyselauksessa = true);
                break;

            case 3: //Aloitusvalitsin

                haluttulevy = "exit";
        }
        }
        while (!haluttulevy.equals("exit"));
    
    return haluttulevy ;

}

public void lopetus() {
        JOptionPane.showMessageDialog(null, "Poistuit levykaupasta, "
                + "lompakkoosi jäi " + kauppa.lompakko.getRahamaara() + "euroa"
                + " ja kaupan kassaan jäi " + kauppa.myyja.kassa.getRahaakassassa() + "euroa.");
    }
}
