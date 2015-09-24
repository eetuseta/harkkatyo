package harkkatyo;

//Myyjä joka osaa kysyä Levyt-classilta onko jotain levyä
//Osaa vastata kysyttäessä onko jotain levyä getOnkolevya

public class Myyja {
    
    
    private Levyt levyt;
    
    public Myyja (){
    }
    //Metodit
    public void Levyt(Levyt levyt){
        this.levyt=levyt;
    }
    public String getOnkolevya(String levy){
        return levyt.getOnkoLevya(levy);
    }

}
