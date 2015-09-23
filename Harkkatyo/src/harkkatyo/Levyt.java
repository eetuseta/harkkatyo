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
    FileReader fr = null;
    BufferedReader br = null;
    String artisti, levynNimi;
    int hinta;    
    Levy levy = null;

    //konstruktori
    public Levyt() {
        lue();
    }
    
    public boolean lue(){
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
    }
    //alpha buildi
    int tosi = 1;
    public boolean getOnkoLevya(){   
    if (tosi == 1){
        return true;
    }   
    else {
        return false;
    }
    }
}

    
