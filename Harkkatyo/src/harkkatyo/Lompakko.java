
package harkkatyo;

public class Lompakko {
    //alustetaan lompakkoon rahamäärä
    private int rahamaara=100;
    
    //konstruktorit
    public Lompakko(){
            }
    //lompakko saa sisäänsä rahaa
    public Lompakko(int rahamaara){
        this.rahamaara=rahamaara;
    }
    
    //metodit
    //asetetaan alustettu rahamäärä
    public void setRaha(int rahamaara){
        this.rahamaara=rahamaara;
    }
    //palautetaan rahamäärä kysyjälle
    public int getRahamaara(){
        return rahamaara;
    }
    //lisätään rahaa lompakkoon
    public void lisaa(int pano){
        rahamaara=rahamaara+pano;
    }
    //vähennetään rahaa lompakosta
    boolean vahenna(int otto){
        if (otto>rahamaara){
            System.out.println("Ei ole mistä ottaa, sori...");
            return false;
    }
        else {
            rahamaara=rahamaara-otto;
            return true;
                    } 
}
}