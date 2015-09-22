/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harkkatyo;

/**
 *
 * @author Eetu
 */
public class Kauppa {

        Myyja myyja = new Myyja();
        Asiakas asiakas = new Asiakas();
        Levyt levyt = new Levyt();
        UI ui = new UI();
        
        public void kaynnista(){
        ui.Aloitalevykauppa();
        }
        
        //Metodit
        public boolean getOnkolevya(String haluttulevy){
            if (asiakas.onkoLevya(haluttulevy) == true){
                return true;
            }
                else {
                return false;
            }      
        }
        
    public static void main(String[] args) {
        Kauppa kauppa = new Kauppa();
        kauppa.kaynnista();

    
    }
}
