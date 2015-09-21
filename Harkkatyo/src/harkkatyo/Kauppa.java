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

    public static void main(String[] args) {
        Myyja myyja = new Myyja();
        Asiakas asiakas = new Asiakas();
        Levyt levyt = new Levyt();
        UI ui = new UI();
        
        ui.Aloitalevykauppa();
    }
}
