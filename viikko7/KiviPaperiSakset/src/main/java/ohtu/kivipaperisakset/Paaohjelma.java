package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static IO io = new KonsoliIO();

    public static void main(String[] args) {
        KPSTehdas kpsTehdas = new KPSTehdas(io);

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = io.nextLine();

            if (vastaus.matches("[abc]")) {
                KPS peli;
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");

                if (vastaus.equals("a")) {
                    peli = kpsTehdas.luoKaksinpeli();
                } else if (vastaus.equals("b")) {
                    peli = kpsTehdas.luoHelppoYksinpeli();
                } else {
                    peli = kpsTehdas.luoVaikeaYksinpeli();
                }

                peli.pelaa();
            } else {
                break;
            }

        }

    }
}
