package harkkatyo;

//Myyjän käytössä oleva kassa
public class Kassa {
    
    private double kassanraha;
    
    public Kassa(){
    }
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
