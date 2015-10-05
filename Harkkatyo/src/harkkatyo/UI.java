//Viewer class jossa tapahtuu kaikki kommunikointi käyttäjän kanssa
package harkkatyo;

import java.util.*;
import javax.swing.*;

public class UI {
    //esitetään skanneri
    private static Scanner lukija = new Scanner(System.in);
//Muuttujat
    final Kauppa kauppa;
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
    //Esitellään kauppa UI:lle
    public UI(Kauppa kauppa) {
        this.kauppa = kauppa;
    }

    //METODIT
    
    //Tämä ottaa vastaan Levy-olioiden listan, tulostaa alkuun "Tällaista" ja
    //sitten muuttaa sen riviriviltä Stringiksi jossa on rivinvaihto JOptionPanea
    //varten luettavaksi.
    public String Forlauseke(List<Levy> vastaus) {
        String listaus = "Tällaista:";
        for (Levy albumi : vastaus) {
            listaus = listaus + "\n" + albumi;
        }
        return listaus;
    }
    //Tämä on ohjelman toiminnallinen osa jossa kaikki Kysymykset
    public String Aloitalevykauppa() {
        //tällä pysytään aloitusvalikon loopissa haluttaessa
        boolean pysyaloituksessa = true;
        while (pysyaloituksessa == true) {
            //Tällä kysytään alkutekstiä kunnes oikea syöte tulee
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
                //Tässä tarkistetaan että käyttäjä syöttää jonkun oikeista vaihtoehdoista
                if (!aloitus.equals("exit") && !aloitus.equals("1") && !aloitus.equals("2") && !aloitus.equals("3")) {
                    kysyalkua = true;
                //oikea syöte tulee niin se muutetaan INT tyyppiseksi jotta switch osaa lukea sen
                } else {
                    valitsin = Integer.parseInt(aloitus);
                    kysyalkua = false;
                }
            }
            switch (valitsin) {
                case 1: //Aloitusvalitsimen
                    //Tällä pysytään Case 1 loopissa
                    pysymyyjankysymyksessa = true;
                    while (pysymyyjankysymyksessa == true) {

                        //Kysytään mikä levy
                        haluttulevy = JOptionPane.showInputDialog(null, "Myyjä kysyy: Mitä levyä etsit?\n");
                        //Tässä tulos jos levyä ei löydy
                        while (kauppa.getOnkolevya(haluttulevy) == null && !haluttulevy.equals("1")) {
                            haluttulevy = JOptionPane.showInputDialog(null, "Myyjän hupparinhiha värähtää, mutta pysähtyy. Hän nostaa toista \n"
                                    + "kulmakarvaansa ja murahtaa, hänen väsyneet silmänsä kertovat tarinan \n"
                                    + "entisestä soolokitaristista, jonka unelmat ovat kauan sitten kuolleet. \n\n"
                                    + "Voit kysyä jotain muuta levyä tai artistia kirjoittamalla se\n"
                                    + "-tai-\n"
                                    + "1 Poistua tiskiltä.", "1");
                        }
                        //Tässä voidaan poistua Case 1 loopista alkuun
                        if (haluttulevy.equals("1")) {
                            pysylevynostossa = false;
                            pysymyyjankysymyksessa = false;
                            pysyaloituksessa = true;
                            kysyalkua = true;
                            break;
                        } //Tässä etsitään vastauksella ja tehdään siitä taulukko tänne
                        else {
                            pysylevynostossa = true;
                            vastaus = kauppa.getOnkolevya(haluttulevy);
                        }
                        //Tulostetaan lista ja kysytään ostoa, looppi
                        while (pysylevynostossa == true) {
                            //Forlauseke on sisäinen metodi joka muuttaa Levy-olioiden listan Stringiksi rivinvaihdoilla
                            levynostovalitsin = JOptionPane.showInputDialog("Myyjä sanoo: Kyllähän meiltä löytyy!\n"
                                    + Forlauseke(vastaus)
                                    + "\n"
                                    + "\nKirjoita levyn nimi, jonka haluat ostaa.\n"
                                    + "-tai-\n"
                                    + "\n1 Tarkista paljon lompakossasi on rahaa."
                                    + "\n2 Palaa takaisin.");
                            //Tarkistetaan onko syöte valintanumero vai halutaanko ostaa
                            if (!levynostovalitsin.equals("1") && !levynostovalitsin.equals("2")) {
                                //Tässä listataan kaikki vastauslistan levyt ja tarkistetaan onko sama levynnimi, kun se löytyy sen hinta asetetaan 
                                for (Levy oikea : vastaus) {
                                    if (levynostovalitsin.equalsIgnoreCase(oikea.levynNimi)) {
                                        ostettavanhinta = oikea.hinta;
                                    }
                                }
                                //ja nyt haettua hintaa käytetään ja tarkistetaan onko rahaa siihen, jos on se siirretään lompakosta kassaan
                                if (kauppa.asiakas.maksaLevy(ostettavanhinta) == true) {
                                    JOptionPane.showMessageDialog(null, "Myyja sanoo: Oleppa hyvä!"
                                            + "\n\nLompakkoosi jäi vielä " + kauppa.lompakko.getRahamaara() + "euroa.");
                                    //jos rahaa ei ole ilmoitetaan virheteksti
                                } else {
                                    JOptionPane.showMessageDialog(null, "Sinulla ei ole varaa, levy maksaa "
                                            + ostettavanhinta + "euroa ja sinulla on lompakossa " + kauppa.lompakko.getRahamaara());
                                }
                                //asetetaan kriteerit että looppi palaa takaisin viimeisimpään valikkoon
                                pysylevynostossa = true;
                                levynostovalitsin = "3";
                            }
                            //jos levynostovalitsin-String on ollut 1,2,3 niin muuutetaan se INT ja käytetään switchissä
                            int valitsin2 = Integer.parseInt(levynostovalitsin);
                            switch (valitsin2) {

                                case 1: //Levynostovalitsimen "tarkista lompakon raha"
                                    JOptionPane.showMessageDialog(null, "Lompakossasi on " + kauppa.lompakko.getRahamaara() + "euroa .");
                                    pysylevynostossa = true;
                                    break;

                                case 2://Levynostovalitsimen "poistu"
                                    pysylevynostossa = false;
                                    pysymyyjankysymyksessa = false;
                                    kysyalkua = true;
                                    break;

                                case 3: //Levynostovalitsimen ylimääräinen joka ei tee mitään, palaa takaisin, käytetään loopissa pysymiseen aiemmin
                                    pysylevynostossa = true;
                                    break;
                            }
                        }
                    }
                    break;

                case 2: //Aloitusvalitsin "Selataan itse levyjä

                    //Tehdään looppi jolla selauksessa kysytään mikä kirjain
                    pysyselauksessa = true;
                    while (pysyselauksessa == true) {
                        String selaus = "";
                        selaus = JOptionPane.showInputDialog("Puiset ja pölyiset hyllyt notkuvat raskasta metallimusiikkia\n"
                                + "\nMiltä kohdalta selataan? (A-Z)");
                        //Tehdään sisempi looppi jossa pysytään valikossa ja näytetään samat hakutulokset
                        boolean pysyselauslistassa = true;
                        while (pysyselauslistassa == true) {
                            //luodaan arraylist, annetaan sille tiedot kaupasta etukirjaimen mukaan jota myöhemmin
                            //käytetään hinnan etsimiseen oikealle levylle
                            ArrayList<Levy> selauslista = new ArrayList();
                            selauslista = kauppa.asiakas.tulostaLevja(selaus);
                            //selaaLevja antaa valmiin stringin jossa on rivinvaihdot
                            selausvalinta = JOptionPane.showInputDialog(null, "Tällä kohdalla on:\n"
                                    + kauppa.asiakas.selaaLevja(selaus) + "\n"
                                    + "\nKirjoita levyn nimi, jonka haluat ostaa\n"
                                    + "-tai-\n"
                                    + "1 Tarkista paljon lompakossasi on rahaa\n"
                                    + "2 Selaa muita levyjä\n"
                                    + "3 Poistu hyllyjen luota");
                            //jos käyttäjä ei syöttänyt vaihtoehtoja, tarkistetaan levyn nimellä lista ja hinnan löytyessä asetetaan se
                            if (!selausvalinta.equals("1") && !selausvalinta.equals("2")
                                    && !selausvalinta.equals("3")) {
                                for (Levy oikea : selauslista) {
                                    if (selausvalinta.equalsIgnoreCase(oikea.levynNimi)) {
                                        ostettavanhinta = oikea.hinta;
                                    }
                                }
                                //käytetään löydettyä hintaa ja maksetaan sillä jos toimii
                                if (kauppa.asiakas.maksaLevy(ostettavanhinta) == true) {
                                    JOptionPane.showMessageDialog(null, "Myyja sanoo: Oleppa hyvä!"
                                            + "\n\nLompakkoosi jäi vielä " + kauppa.lompakko.getRahamaara() + "euroa.");
                                    //ja jos ei toimi
                                } else {
                                    JOptionPane.showMessageDialog(null, "Sinulla ei ole varaa, levy maksaa "
                                            + ostettavanhinta + "euroa ja sinulla on lompakossa " + kauppa.lompakko.getRahamaara());
                                }
                                break;
                            //jos valinta oli 1,2,3 niin muutetaan INT tyypiksi jotta switch lukee sen
                            } else {
                                valitsin3 = Integer.parseInt(selausvalinta);
                            }
                            //"levyn selauksen" valitsin
                            switch (valitsin3) {
                                //"näytä lompakon raha" 
                                case 1:
                                    JOptionPane.showMessageDialog(null, "Lompakossasi on " + kauppa.lompakko.getRahamaara() + "euroa.");
                                    pysyselauksessa = true;
                                    kysykirjainta = false;
                                    pysyselauslistassa = true;
                                    break;
                                //"etsi toisella kirjaimella", heittää pois tästä loopista muttei aiemmasta
                                case 2:
                                    pysyselauksessa = true;
                                    pysyselauslistassa = false;
                                    break;
                                //"poistu" heittää pois tästä, aiemmasta ja säätää että alkulooppiin päästään sisälle
                                case 3:
                                    pysyselauksessa = false;
                                    pysyaloituksessa = true;
                                    pysyselauslistassa = false;
                                    kysyalkua = true;
                                    break;
                            }
                        }
                    }

                    break;
                //Aloitusvalikon "poistu kaupasta", Ohjelma loppuu ja näyttää lompakon ja kassan sisällön
                case 3:
                    pysyaloituksessa = false;
                    break;
            }
        }
        return "exit";
    }
    //Tämä suoritetaan ennen ohjelman loppua ja näyttää lompakkosi sisällön ja kassan sisällön
    public void lopetus() {
        JOptionPane.showMessageDialog(null, "Poistuit levykaupasta, "
                + "lompakkoosi jäi " + kauppa.lompakko.getRahamaara() + "euroa"
                + " ja kaupan kassaan jäi " + kauppa.myyja.kassa.getRahaakassassa() + "euroa.");
    }
}
