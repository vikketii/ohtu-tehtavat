package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;

public class KPSParempiTekoaly extends KPS {
    TekoalyParannettu tekoaly;

    public KPSParempiTekoaly(IO io) {
        super(io);
        this.tekoaly = new TekoalyParannettu(20);
    }

    @Override
    protected String tokanSiirto() {
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        tekoaly.asetaSiirto(ekanSiirto);
        return tokanSiirto;
    }
}
