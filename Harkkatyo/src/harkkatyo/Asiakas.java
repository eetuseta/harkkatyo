package harkkatyo;

//tuodut kirjastot
import java.util.*;

public class Asiakas {

    //alustetaan muuttujat
    private Myyja myyja;
    private Lompakko lompakko;
    private Levyt levyt;
    public String levy;

    //luodaan skanneri kyselyä varten
    static Scanner lukija = new Scanner(System.in);

    //asiakkaan konstruktori
    public Asiakas() {

    }

    //levyjen konstruktori
    public void Levyt(Levyt levyt) {
        this.levyt = levyt;
    }

    //lompakon konstruktori
    public void Lompakko(Lompakko lompakko) {
        this.lompakko = lompakko;
    }

    //myyjän konstruktori
    public void Myyja(Myyja myyja) {
        this.myyja = myyja;
    }

    //levyn kysely
    public List<Levy> onkoLevya(String levy) {
        return myyja.getOnkolevya(levy);

    }

    //levy halutaan ostaa, ja ostetaan jos on rahaa.
    public boolean maksaLevy(int hinta) {
        if (lompakko.getRahamaara() > hinta) {
            lompakko.vahenna(hinta);
            return true;
        } else {
            return false;
        }
    }

    //Kysytään mitä levyjä halutaan selata, stringinä!
    public String selaaLevja(String selaus) {
        //alustetaan syöte tyhjäksi
        String palautus = "";

        //pakotetaan merkki aina samaksi, helpottaa tutkimista
        String merkki = selaus.toUpperCase();
        //Otetaan vain ensimmäinen merkki.
        char cmerkki = merkki.charAt(0);
        //selataan levyistä kyseisellä kirjaimella alkavat for-loopilla
        for (Levy i : levyt.levyt) {
            if (cmerkki == ((i.artisti).charAt(0))) {
                palautus = palautus + "\n" + i;

            }

        }
        //jos ei löydy levyjä ko kirjaimen alta
        if (palautus.length() == 0) {
            palautus = "Valitettavasti tämän kirjaimen alla ei ole levyjä.";

        }
        return palautus;
    }

    //Tässä käsitellään levylista ostoa varten. Kyseessä siis koko olio, ei pelkkä string

    public ArrayList<Levy> tulostaLevja(String selaus) {
        //tyhjä syöte
        String palautus = "";
        //pakotetaan merkki yleispäteväksi
        String merkki = selaus.toUpperCase();
        ArrayList<Levy> listaus = new ArrayList();
        char cmerkki = merkki.charAt(0);
        //käydään levyt läpi for-loopilla
        for (Levy i : levyt.levyt) {
            if (cmerkki == ((i.artisti).charAt(0))) {
                listaus.add(i);

            }

        }
        //jos ei löydy
        if (palautus.length() == 0) {
            palautus = "Valitettavasti tämän kirjaimen alla ei ole levyjä.";

        }
        return listaus;
    }
}
