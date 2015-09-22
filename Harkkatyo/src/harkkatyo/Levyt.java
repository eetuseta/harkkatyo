package harkkatyo;
import java.io.*;
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
    FileReader fr = null;
    BufferedReader br = null;
    String artisti, levynNimi;
    int hinta;    
    Levy levy = null;

    //konstruktori
    public Levyt() {}
    
    //metodit
    public boolean lue(){
    
        try {
            fr = new FileReader("C:\\Oliot\\ohjelmointi\\harkkatyo\\levyt.txt");
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
    }
    public boolean getOnkoLevya(){   
    return true;    
    }
}

    
