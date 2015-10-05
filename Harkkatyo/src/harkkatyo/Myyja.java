package harkkatyo;
import java.util.*;
//Myyjä joka osaa kysyä Levyt-classilta onko jotain levyä
//Osaa vastata kysyttäessä onko jotain levyä getOnkolevya

public class Myyja {
    //alustetaan muuttujat
    //lisätään kassaan rahaa
    Kassa kassa = new Kassa(100);   
    private Levyt levyt;
    
    
    public Myyja (){
    }
    //Metodit
    //levyn maksun vastaanotto
    public void Maksakassaan(int summa){
        kassa.Maksa(summa);
    }
    //levylistaus
    public void Levyt(Levyt levyt){
        this.levyt=levyt;
    }
    //levykysely
    public List<Levy> getOnkolevya(String levy){
        return levyt.getOnkoLevya(levy);
    }

}
