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
        levyt.ensureCapacity(725);
        lue();
    }

    private void lue() {
        try (FileReader fr = new FileReader("resources\\levyt.txt");
                BufferedReader br = new BufferedReader(fr)) {
            String rivi = br.readLine();

            while (rivi != null) {
                String[] tiedot = rivi.split("-");
                artisti = tiedot[0];
                levynNimi = tiedot[1];
                hinta = Integer.parseInt(tiedot[2]);

                levy = new Levy(artisti, levynNimi, hinta);
                levyt.add(levy);
                rivi = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //testi syntyykö kaikki levyt
        /*for (Levy levy : levyt) {
            System.out.println(levy.artisti + " : " + levy.levynNimi + " " + levy.hinta + "€");
        }*/
    }

    public List<Levy> getOnkoLevya(String haku) {
        ArrayList<Levy> hakutulos = new ArrayList();
        String tulos = null;

        for (Levy levy : levyt) {
            if (haku.equalsIgnoreCase(levy.artisti) || haku.equalsIgnoreCase(levy.levynNimi)) {
                hakutulos.add(levy);
            }
        }
        if (hakutulos.size() == 0) {
            return null;
        }
        return hakutulos;
    }
}
