package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KPS {
    Tekoaly tekoaly;

    protected KPSTekoaly(IO io) {
        super(io);
        this.tekoaly = new Tekoaly();
    }

    @Override
    protected String tokanSiirto() {
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        return tokanSiirto;
    }
}