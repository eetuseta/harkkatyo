package harkkatyo;

//Myyjän käytössä oleva kassa
public class Kassa {
    //alustetaan muuttujat
    private int kassanraha;
    //tyhjä konstruktori
    public Kassa(){
    }
    //kerrotaan että kassassa on rahaa
    public Kassa (int raha){
        this.kassanraha=raha;
    }
    
    //Metodit
    
    public void Maksa(int raha){     //Lisää kassaan rahaa
        this.kassanraha = raha + this.kassanraha;
    } 
    
    public int getRahaakassassa(){   //Palauttaa paljon kassassa on rahaa
        return kassanraha;
    }
    
    
    
}
