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
    boolean pysyselauksessa = true;
    private int ostettavanhinta = 0;
    private int valitsin3;
    private boolean pysymyyjankysymyksessa = true;
    private boolean kysyalkua = true;
    private int valitsin;
    boolean kysykirjainta = true;
    private String levynostovalitsin;
    
//KONSTRUKTORIT
    //public UI (){}
    public UI(Kauppa kauppa) {
        this.kauppa = kauppa;
    }

    //METODIT
    public String Forlauseke(List<Levy> vastaus) {
        String listaus = "Tällaista:";
        for (Levy albumi : vastaus) {
            listaus = listaus + "\n" + albumi;
        }
        return listaus;
    }

    public String Aloitalevykauppa() {
        //tällä pysytään aloitusvalikon loopissa
        boolean pysyaloituksessa = true;
        while (pysyaloituksessa == true){

            while (kysyalkua == true) {
                String aloitus = null;
                aloitus = JOptionPane.showInputDialog(null, "Levykaupan ikkunat ovat mustat, muutama tunnistettava\n"
                        + "levy on asetettu näkyviin. Ovi on terästä ja sen saranat ruosteessa.\n"
                        + "Päätät astua sisään levykauppaa."
                        + "\n\n"
                        + "Haluatko kysyä levyä myyjältä, selata itse hyllyjä vai kävellä ulos?"
                        + "\n1 Kysy levyä myyjältä."
                        + "\n2 Selaa levyjä hyllystä."
                        + "\n3 Kävele ulos.\n");
                if (!aloitus.equals("exit") && !aloitus.equals("1") && !aloitus.equals("2") && !aloitus.equals("3")) {
                    kysyalkua = true; 
                } else {
                    valitsin = Integer.parseInt(aloitus);
                    kysyalkua = false;
                }
            }
            switch (valitsin) {
                case 1: //Aloitusvalitsimen
                    pysymyyjankysymyksessa = true;
                    while (pysymyyjankysymyksessa == true){
                        
                        haluttulevy = JOptionPane.showInputDialog("Myyjä kysyy: Mitä levyä etsit?\n");
                        while (kauppa.getOnkolevya(haluttulevy) == null && !haluttulevy.equals("1")) {
                            haluttulevy = JOptionPane.showInputDialog(null, "Myyjän hupparinhiha värähtää, mutta pysähtyy. Hän nostaa toista \n"
                                    + "kulmakarvaansa ja murahtaa, hänen väsyneet silmänsä kertovat tarinan \n"
                                    + "entisestä soolokitaristista, jonka unelmat ovat kauan sitten kuolleet. \n\n"
                                    + "Voit kysyä jotain muuta levyä tai artistia kirjoittamalla se\n"
                                    + "-tai-\n"
                                    + "1 Poistua tiskiltä.");                          
                        }
                        if (haluttulevy.equals("1")){
                            pysylevynostossa = false;
                            pysymyyjankysymyksessa = false;
                            pysyaloituksessa = true;
                            kysyalkua = true;
                            break;                                                   
                        }
                        else {
                            pysylevynostossa = true;
                            vastaus = kauppa.getOnkolevya(haluttulevy);
                        }
                        while (pysylevynostossa == true) {
                            
                            levynostovalitsin = JOptionPane.showInputDialog("Myyjä sanoo: Kyllähän meiltä löytyy!\n"
                                    + Forlauseke(vastaus)
                                    + "\n"
                                    + "\nKirjoita levyn nimi, jonka haluat ostaa.\n"
                                    + "-tai-\n"
                                    + "\n1 Tarkista paljon lompakossasi on rahaa."
                                    + "\n2 Palaa takaisin.");

                            if (!levynostovalitsin.equals("1") && !levynostovalitsin.equals("2")) {

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
                                levynostovalitsin = "3";
                            }
                            int valitsin2 = Integer.parseInt(levynostovalitsin);
                            switch (valitsin2) {

                                
                                case 1: //Levynostovalitsimen
                                    JOptionPane.showMessageDialog(null, "Lompakossasi on " + kauppa.lompakko.getRahamaara() + "euroa .");
                                    pysylevynostossa = true;
                                    break;

                                case 2://Levynostovalitsimen
                                    pysylevynostossa = false;
                                    pysymyyjankysymyksessa = false;
                                    kysyalkua = true;
                                    break;
                                
                                case 3: 
                                    pysylevynostossa = true;
                                    break;
                            }
                        } 
                    }
                    break;

                case 2: //Aloitusvalitsin
                        pysyselauksessa = true;
                        while (pysyselauksessa == true){
                        String selaus = "";
                        selaus = JOptionPane.showInputDialog("Miltä kohdalta selataan? (A-Z)");
                        ArrayList<Levy> selauslista = new ArrayList();
                        selauslista = kauppa.asiakas.tulostaLevja(selaus);                        
                        selausvalinta = JOptionPane.showInputDialog(null, "Tällä kohdalla on:\n"
                                + kauppa.asiakas.selaaLevja(selaus) + "\n"
                                + "\nKirjoita levyn nimi, jonka haluat ostaa\n"
                                + "-tai-\n"
                                + "1 Tarkista paljon lompakossasi on rahaa\n"
                                + "2 Selaa muita levyjä\n"
                                + "3 Poistu hyllyjen luota");
                        if (!selausvalinta.equals("1") && !selausvalinta.equals("2") && 
                                !selausvalinta.equals("3")) {
                            for (Levy oikea : selauslista) {
                                if (selausvalinta.equalsIgnoreCase(oikea.levynNimi)) {
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
                            break;

                        } else {
                            valitsin3 = Integer.parseInt(selausvalinta);
                        }
                        switch (valitsin3) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Lompakossasi on "+kauppa.lompakko.getRahamaara()+"euroa.");
                                pysyselauksessa = true;
                                kysykirjainta = false;
                                break;
                            case 2:
                                pysyselauksessa = true;
                                break;
                            case 3:
                                pysyselauksessa = false;
                                pysyaloituksessa = true;
                                kysyalkua = true;
                                break;
                        }
                        }
                    //} while (pysyselauksessa = true);
                break;
                //aloitusvalitsimen case 3, jossa koko-ohjelman do-rakenteesta karataan muuttamalla haluttulevyarvo "exit
                //arvoon.
                case 3:
                    pysyaloituksessa = false;
                    //kysyalkua = true;
                    break;
            }
        }
        return "exit";
    }

    public void lopetus() {
        JOptionPane.showMessageDialog(null, "Poistuit levykaupasta, "
                + "lompakkoosi jäi " + kauppa.lompakko.getRahamaara() + "euroa"
                + " ja kaupan kassaan jäi " + kauppa.myyja.kassa.getRahaakassassa() + "euroa.");
    }
}
