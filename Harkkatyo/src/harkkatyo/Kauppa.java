// Main ohjelma, sekä kauppa class jonka kautta kaikki tieto kulkee UI:lta Olioille
package harkkatyo;

import java.util.*;

public class Kauppa {

    //Kauppaolion ominaisuudet ja kutsut
    Myyja myyja = new Myyja();
    Asiakas asiakas = new Asiakas();
    Levyt levyt = new Levyt();

    //kutsutaan käyttöliittymää
    UI ui = new UI(this);

    //lisätään asiakkaan lompakkoon rahaa
    Lompakko lompakko = new Lompakko(50);

    //Metodit
    public void kaynnista() { //Tämä on ensimmäinen ohjelman osa, käynnistää UI:n
        asiakas.Myyja(myyja);
        asiakas.Levyt(levyt);
        myyja.Levyt(levyt);
        asiakas.Lompakko(lompakko);
        do {
            ui.Aloitalevykauppa();
        } while (!ui.Aloitalevykauppa().equals("exit"));   //Ohjelma loppuu
    }

    //levyn haku tietokannasta, kysymys asiakkaalla

    public List<Levy> getOnkolevya(String haluttulevy) {
        return asiakas.onkoLevya(haluttulevy);

    }

    //ohjelman lopetus

    public void lopetus() {
        ui.lopetus();
    }

    //Varsinainen main
    public static void main(String[] args) {

        Kauppa kauppa = new Kauppa();       //luodaan kauppaolio
        kauppa.kaynnista();                 //käynnistetään metodi joka käynnistää UI:n 
        kauppa.lopetus();                   //suoritetaan aina ennen ohjelman loppua.
        System.exit(0);

    }
}
