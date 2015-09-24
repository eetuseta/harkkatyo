package harkkatyo;
import java.io.*;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jaakkoen
 */
public class Levyt {
    ArrayList<Levy> levyt = new ArrayList();
    String artisti, levynNimi;
    int hinta;    
    Levy levy = null;

    //konstruktori
    public Levyt() {
        lue();
    }
    
    private void lue(){
        try(FileReader fr = new FileReader("resources\\testilevyt.txt");
            BufferedReader br = new BufferedReader(fr)){
            String rivi = br.readLine();
            
            while(rivi != null){
                String[] tiedot = rivi.split("-");
                artisti = tiedot[0];
                levynNimi = tiedot[1];
                hinta = Integer.parseInt(tiedot[2]);
            
                levy = new Levy(artisti, levynNimi, hinta);
                levyt.add(levy);
                rivi = br.readLine();
            }
        }    
        catch(Exception e){
        }
    
    //testi syntyykö kaikki levyt
        for(Levy levy : levyt){
            System.out.println(levy.artisti+" : "+levy.levynNimi+" "+levy.hinta +"€");
    }
    }
    public String getOnkoLevya(String haku){   
        String tulos = "Ei oo.";
        
        for(Levy levy : levyt){
            if (haku.equalsIgnoreCase(levy.artisti) || haku.equalsIgnoreCase(levy.levynNimi)) {
            tulos = (levy.artisti+" "+levy.levynNimi+" "+levy.hinta+"€");
            }
        }
        return tulos;
    }
        

}

    
