
// Main ohjelma, sekä kauppa class jonka kautta kaikki tieto kulkee UI:lta Olioille
package harkkatyo;


public class Kauppa {
        
        //Kauppaolion ominaisuudet
        
        Myyja myyja = new Myyja();
        Asiakas asiakas = new Asiakas();
        Levyt levyt = new Levyt();
        UI ui = new UI();
        Lompakko lompakko = new Lompakko();
        
        //Metodit
        
        public void kaynnista(){                            //Tämä on ensimmäinen ohjelman osa, käynnistää UI:n
            ui.Aloitalevykauppa();
        }
                
        public boolean getOnkolevya(String haluttulevy){    
            if (asiakas.onkoLevya() == true){
                return true;
            }
            else {
                return false;
            }      
        }
        
        //Varsinainen main -
        
    public static void main(String[] args) {
        Kauppa kauppa = new Kauppa();       //luodaan kauppaolio
        kauppa.kaynnista();                 //käynnistetään metodi joka käynnistää UI:n 

    
    }
}
