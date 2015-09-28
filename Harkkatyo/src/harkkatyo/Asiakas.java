package harkkatyo;

import java.util.*;
import javax.swing.JOptionPane;

public class Asiakas {

    //muuttujat
    private Myyja myyja;
    private Lompakko lompakko;
    public int hinta;
    private Levyt levyt;

    public String levy;//teksti

    //luodaan skanneri
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
    public boolean maksaLevy(int rahamaara) {
        if (lompakko.getRahamaara() > hinta) {
            lompakko.vahenna(hinta);
            return true;
        } else {
            return false;
        }
    }

    public String selaaLevja(String selaa) {
        String palautus = "";
        String merkki = JOptionPane.showInputDialog("Miltä kohdalta selataan? (A-Z");
        char cmerkki = merkki.charAt(0);
        for (Levy i : levyt.levyt) {
            if (cmerkki == ((i.artisti).charAt(0))) {
                palautus = palautus + i + "/n";
                
            }
            

        }
        return palautus;
    }
}
    

    /*ArrayList<Levy> hakutulos = new ArrayList();
     String loytyi = null;

     for (Levy levy : levyt) {
     if (haku.equalsIgnoreCase(levy.artisti) || haku.equalsIgnoreCase(levy.levynNimi)) {
     hakutulos.add(levy);
     }
     }
     if (hakutulos.size() == 0) {
     return null;
     }
     return hakutulos;
     }*/

