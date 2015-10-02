package harkkatyo;

public class Levy {
    //alustetaan muuttujat
    String artisti, levynNimi;
    int hinta;
    
    //konstruktorit
    public Levy(String artisti, String levynNimi, int hinta){
        this.artisti=artisti;
        this.levynNimi=levynNimi;
        this.hinta=hinta;
    }
    //pakottaa tulosteen string-muotoon
    @Override
    public String toString() {
        return (artisti + ": " +levynNimi +" " +hinta +" €");
    }
}
