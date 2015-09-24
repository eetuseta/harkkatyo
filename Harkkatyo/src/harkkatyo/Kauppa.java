
// Main ohjelma, sekä kauppa class jonka kautta kaikki tieto kulkee UI:lta Olioille
package harkkatyo;


public class Kauppa {
        
        //Kauppaolion ominaisuudet
        
        Myyja myyja = new Myyja();
        Asiakas asiakas = new Asiakas();
        Levyt levyt = new Levyt();
        UI ui = new UI(this);
        Lompakko lompakko = new Lompakko(50);
        
        //Metodit
        
        
        public void kaynnista(){                                //Tämä on ensimmäinen ohjelman osa, käynnistää UI:n
            asiakas.Myyja(myyja);
            myyja.Levyt(levyt);
            do { 
                ui.Aloitalevykauppa();
            }
            while (!ui.Aloitalevykauppa().equals("exit"));   //Ohjelma loppuu
        }
                
        public String getOnkolevya(String haluttulevy){    
            return asiakas.onkoLevya(haluttulevy);
            
        }
        
        //Varsinainen main -
        
    public static void main(String[] args) {
        
        Kauppa kauppa = new Kauppa();       //luodaan kauppaolio
        kauppa.kaynnista();                 //käynnistetään metodi joka käynnistää UI:n 
        System.exit(0);
    
    }
}
