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
    //FileReader fr = null;
    //BufferedReader br = null;
    String artisti, levynNimi;
    int hinta;    
    Levy levy = null;

    //konstruktori
    public Levyt() {
        lue();
    }
    //tämä tiedoston luku metodi TOIMII, mutta lukee vaan ensimmäisen rivin :)
    /*private boolean lue(){
        try {
            fr = new FileReader("resources\\levyt.txt");
            br = new BufferedReader(fr);
            String tieto = br.readLine();
            String[] tiedot = tieto.split("-");
            artisti = tiedot[0];
            levynNimi = tiedot[1];
            hinta = Integer.parseInt(tiedot[2]);
            
            levy = new Levy(artisti, levynNimi, hinta);
            
            System.out.println(levy.artisti);
            System.out.println(levy.levynNimi);
            System.out.println(levy.hinta);
            
            return true;
        }
        catch(Exception e){
        e.printStackTrace();
        return false;
        }
    }*/
    
    private void lue(){
        try(FileReader fr = new FileReader("resources\\levyt.txt");
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
            e.printStackTrace();
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

    
