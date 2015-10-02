package harkkatyo;

//Myyjän käytössä oleva kassa
public class Kassa {
    //alustetaan muuttujat
    private double kassanraha;
    //tyhjä konstruktori
    public Kassa(){
    }
    //kerrotaan että kassassa on rahaa
    public Kassa (double raha){
        this.kassanraha=raha;
    }
    
    //Metodit
    
    public void Maksa(double raha){     //Lisää kassaan rahaa
        this.kassanraha = raha + this.kassanraha;
    } 
    
    public double getRahaakassassa(){   //Palauttaa paljon kassassa on rahaa
        return kassanraha;
    }
    
    
    
}
