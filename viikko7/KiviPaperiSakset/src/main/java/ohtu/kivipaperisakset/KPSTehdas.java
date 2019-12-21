package ohtu.kivipaperisakset;

public class KPSTehdas {
    private static IO io;

    public static KPS luoKaksinpeli() {
        return new KPSPelaajaVsPelaaja(io);
    }

    public static KPS luoHelppoYksinpeli() {
        return new KPSTekoaly(io);
    }

    public static KPS luoVaikeaYksinpeli() {
        return new KPSParempiTekoaly(io);
    }

    protected KPSTehdas(IO io) {
        this.io = io;
    }
}