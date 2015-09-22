package harkkatyo;

//Myyjä joka osaa kysyä Levyt-classilta onko jotain levyä
//Osaa vastata kysyttäessä onko jotain levyä getOnkolevya

public class Myyja {
    
    String Myyjannimi;
    String kysyttylevy;
    private Levyt levyt;
    
    public Myyja (){
    }
    /*public Myyja (String nimi){
        this.Myyjannimi=nimi;
    }
    */
    //Metodit
    void setLevyt (Levyt levyt){
        this.levyt=levyt;
    }
    public boolean getOnkolevya(){
        if (levyt.getOnkolevya() != true){
            return false;
        }
        else {
            return true;
        }
      
    }
}
