//Viewer class jossa tapahtuu kaikki kommunikointi käyttäjän kanssa
package harkkatyo;

import java.util.*;
import javax.swing.*;

public class UI {

    private static Scanner lukija = new Scanner(System.in);

    private Kauppa kauppa;
    private String haluttulevy = "pysy";
    private boolean pysylevynostossa;
    List<Levy> vastaus;
    private String selausvalinta;
    private boolean pysyselauksessa;
    private int ostettavanhinta = 0;
    private int valitsin3;
    private String aloitus = "pysy";
    private boolean pysymyyjankysymyksessa = true;

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
        int valitsin = 1;
        //tällä pysytään aloitusvalikon loopissa
        boolean pysyaloituksessa = true; 
        do {

            while (aloitus.equals("pysy")) {
                aloitus = JOptionPane.showInputDialog("Levykaupan ikkunat ovat mustat, muutama tunnistettava\n"
                        + "levy on asetettu näkyviin. Ovi on terästä ja sen saranat ruosteessa.\n"
                        + "Päätät astua sisään levykauppaa."
                        + "\n\n"
                        + "haluatko kysyä myyjältä artistia vai kävellä ulos? "
                        + "\n1 Kysy myyjältä artistia."
                        + "\n2 Selaa levyjä hyllystä."
                        + "\n3 Kävele ulos.\n");
                if (!aloitus.equals("exit") && !aloitus.equals("1") && !aloitus.equals("2") && !aloitus.equals("3")) {
                    aloitus = "pysy";
                } else {
                    valitsin = Integer.parseInt(aloitus);
                }
            }
            switch (valitsin) {
                case 1: //Aloitusvalitsimen

                    do {
                        if (haluttulevy.equals("poistu")) {
                            break;
                        }
                        haluttulevy = JOptionPane.showInputDialog("Myyjä kysyy: Mitä artistia etsit?\n");
                        while (kauppa.getOnkolevya(haluttulevy) == null) {
                            JOptionPane.showMessageDialog(null, "Myyjä sanoo: PÖH! Ei me ny ihan mitä vaan\n "
                                    + "sunnuntaiartisteja pidetä hyllyillä notkumassa");
                            haluttulevy = JOptionPane.showInputDialog("Myyjä sanoo: Kysyppä jotain muuta \n");
                        }
                        //if (kauppa.getOnkolevya(haluttulevy) == null) {
                        //    break;
                        //} else {
                        vastaus = kauppa.getOnkolevya(haluttulevy);
                        do {
                            String levynostovalitsin = null;
                            pysylevynostossa = true;
                            levynostovalitsin = JOptionPane.showInputDialog("Myyjä sanoo: Kyllähän meiltä löytyy!\n"
                                    + Forlauseke(vastaus)
                                    + "! \nHaluaisitko ostaa tämän?\n"
                                    + "\nKirjoita levyn nimi, jonka haluat ostaa."
                                    + "\n2 Tarkista paljon lompakossasi on varaa."
                                    + "\n3 Palaa takaisin.");

                            if (!levynostovalitsin.equals("1") && !levynostovalitsin.equals("2")
                                    && !levynostovalitsin.equals("3")) {

                                for (Levy oikea : vastaus) {
                                    if (levynostovalitsin.equalsIgnoreCase(oikea.levynNimi)) {
                                        ostettavanhinta = oikea.hinta;
                                    }
                                }
                                if (kauppa.asiakas.maksaLevy(ostettavanhinta) == true) {
                                    JOptionPane.showMessageDialog(null, "Myyja sanoo: Oleppa hyvä!"
                                            + "\n\nLompakkoosi jäi vielä " + kauppa.lompakko.getRahamaara() + "euroa.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Sinulla ei ole varaa, levy maksaa "
                                            + ostettavanhinta + "euroa ja sinulla on lompakossa " + kauppa.lompakko.getRahamaara());
                                }
                                pysylevynostossa = true;
                                levynostovalitsin = "1";
                            }
                            int valitsin2 = Integer.parseInt(levynostovalitsin);
                            switch (valitsin2) {

                                case 1: //Levynostovalitsimen
                                    /*String ostettavalevy;
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
                                     }*/
                                    pysylevynostossa = true;
                                    break;

                                case 2: //Levynostovalitsimen
                                    JOptionPane.showMessageDialog(null, "Lompakossasi on " + kauppa.lompakko.getRahamaara() + "euroa .");
                                    pysylevynostossa = true;
                                    break;

                                case 3://Levynostovalitsimen
                                    pysylevynostossa = false;
                                    pysymyyjankysymyksessa = false;
                                    aloitus = "pysy";
                                    break;
                            }
                        } while (pysylevynostossa == true);
                    } while (pysymyyjankysymyksessa == true);
                    break;

                case 2: //Aloitusvalitsin
                    do {
                        String selaus = JOptionPane.showInputDialog("Miltä kohdalta selataan? (A-Z)");
                        ArrayList<Levy> selauslista = new ArrayList();
                        selauslista = kauppa.asiakas.tulostaLevja(selaus);
                        selausvalinta = JOptionPane.showInputDialog(null, kauppa.asiakas.selaaLevja(selaus) + "\n"
                                + "\nKirjoita levyn nimi, jonka haluat ostaa\n"
                                + "tai\n"
                                + "2 Selaa muita levyjä\n"
                                + "3 Poistu hyllyjen luota");
                        if (!selausvalinta.equals(1) && !selausvalinta.equals(2) && !selausvalinta.equals(3)) {
                            for (Levy oikea : selauslista) {
                                if (selausvalinta.equalsIgnoreCase(oikea.levynNimi)) {
                                    ostettavanhinta = oikea.hinta;
                                }
                            }
                            if (kauppa.asiakas.maksaLevy(ostettavanhinta) == true) {
                                JOptionPane.showMessageDialog(null, "Myyja sanoo: Oleppa hyvä!"
                                        + "\n\nLompakkoosi jäi vielä " + kauppa.lompakko.getRahamaara() + "euroa.");
                            } else {
                                JOptionPane.showMessageDialog(null, ostettavanhinta);
                            }
                            pysyselauksessa = true;
                            break;

                        } else {
                            valitsin3 = Integer.parseInt(selausvalinta);
                        }
                        switch (valitsin3) {
                            case 1:
                                pysyselauksessa = true;
                                break;
                            case 2:
                                pysyselauksessa = false;
                                break;
                            case 3:
                                pysyselauksessa = false;
                                aloitus = "pysy";
                                break;
                        }
                    } while (pysyselauksessa = true);
                    break;
                //aloitusvalitsimen case 3, jossa koko-ohjelman do-rakenteesta karataan muuttamalla haluttulevyarvo "exit
                //arvoon.
                case 3:
                    pysyaloituksessa = false;
                    aloitus = "exit";
                    break;
            }
        } while (pysyaloituksessa == true);
        return aloitus;
    }

    public void lopetus() {
        JOptionPane.showMessageDialog(null, "Poistuit levykaupasta, "
                + "lompakkoosi jäi " + kauppa.lompakko.getRahamaara() + "euroa"
                + " ja kaupan kassaan jäi " + kauppa.myyja.kassa.getRahaakassassa() + "euroa.");
    }
}
