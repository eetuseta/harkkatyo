package testis;
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
    //konstruktori
    public Levyt() {}
    
    //metodit
    public boolean lue(){
    
        try {
        fr = new FileReader("resources\\levyt.txt");
        br = new BufferedReader(fr);
        String tieto;
        tieto = br.readLine();
            System.out.println(tieto);
            return true;
        }
        catch(Exception e){
        e.printStackTrace();
        return false;
    }
    
    }
}
    
