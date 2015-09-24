package harkkatyo;

import java.util.Scanner;


public class Asiakas {
    
    //muuttujat

    private Myyja myyja;
    private Lompakko lompakko;
    public int hinta;

    public String levy;//teksti
    
    //luodaan skanneri
    static Scanner lukija = new Scanner(System.in);
    
    //asiakkaan konstruktori
    public Asiakas() {

    }
    //myyjän konstruktori
    public void Myyja(Myyja myyja) {
        this.myyja = myyja;
    }
    //levyn kysely
    public String onkoLevya(String levy) {
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

}
