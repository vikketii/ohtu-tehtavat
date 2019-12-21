package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends KPS {

    protected KPSPelaajaVsPelaaja(IO io) {
        super(io);
    }

    @Override
    protected String tokanSiirto() {
        System.out.print("Toisen pelaajan siirto: ");
        String tokanSiirto = io.nextLine();
        return tokanSiirto;
    }
}