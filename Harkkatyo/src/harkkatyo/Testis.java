/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harkkatyo;

import harkkatyo.Levyt;
import java.util.Scanner;
import java.util.*;
//kikkeli

/**
 *
 * @author jaakk_000
 */
public class Testis {
    static Scanner in = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Levyt testi = new Levyt();

        String haku;
        
        haku = in.next();
        String testihaku = testi.getOnkoLevya(haku);
        System.out.println(testihaku);
    }
}
