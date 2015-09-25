package harkkatyo;
import java.util.*;
//Myyjä joka osaa kysyä Levyt-classilta onko jotain levyä
//Osaa vastata kysyttäessä onko jotain levyä getOnkolevya

public class Myyja {
    
    Kassa kassa = new Kassa(100);   
    private Levyt levyt;
    
    
    public Myyja (){
    }
    //Metodit
    public void Maksakassaan(double summa){
        kassa.Maksa(summa);
    }
    public void Levyt(Levyt levyt){
        this.levyt=levyt;
    }
    public List<Levy> getOnkolevya(String levy){
        return levyt.getOnkoLevya(levy);
    }

}
