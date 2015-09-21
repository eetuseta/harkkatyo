/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jaakk_000
 */
import java.util.Scanner;

public class Maksupaate {

    static Scanner lukija = new Scanner(System.in);
    private Maksukortti kortti;
    private double maksu;
    private int PIN;

    public Maksupaate() {

    }

    public void setKortti(Maksukortti kortti) {
        this.kortti = kortti;
    }

    public boolean maksa() {
        int y;
        System.out.println("Anna PIN:");
        PIN = lukija.nextInt();
        y = 1;
        while (PIN != kortti.getPin() && y < 3) {
            System.out.println("Anna PIN:");
            PIN = lukija.nextInt();
            y++;
        }
        if (y == 3) {
            System.out.println("Korttia ei voi käyttää.");
            return false;
        } else {
            System.out.println("Syötä summa:");
            maksu = lukija.nextDouble();
            kortti.maksa(maksu);
            return true;
        }
    }
}
