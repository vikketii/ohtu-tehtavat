
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] luvut;      // Joukon luvut säilytetään taulukon alkupäässä.
    private int alkioidenLkm = 0;    // Tyhjässä joukossa alkioiden_määrä on nolla.

    public IntJoukko() {
        alustaLuokka(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        alustaLuokka(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        alustaLuokka(kapasiteetti, kasvatuskoko);
    }

    public void alustaLuokka(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) throw new IllegalArgumentException("Kapasitteetti negatiivinen");
        if (kasvatuskoko < 0) throw new IllegalArgumentException("Kasvatuskoko negatiivinen");

        luvut = new int[kapasiteetti];
        for (int i = 0; i < luvut.length; i++) luvut[i] = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaaJoukkoon(int luku) {
        if (!lukuKuuluuJoukkoon(luku)) {
            luvut[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm == luvut.length) {
                kasvataJoukkoa();
            }
            return true;
        }
        return false;
    }

    public void kasvataJoukkoa() {
        int[] temp = luvut;
        luvut = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(temp, luvut);
    }

    public boolean lukuKuuluuJoukkoon(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == luvut[i]) return true;
        }
        return false;
    }

    public boolean poistaLukuJoukosta(int luku) {
        int kohta = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == luvut[i]) {
                kohta = i;
                break;
            }
        }
        if (kohta != -1) {
            for (int j = kohta; j < alkioidenLkm - 1; j++) {
                int temp = luvut[j];
                luvut[j] = luvut[j + 1];
                luvut[j + 1] = temp;
            }
            alkioidenLkm--;
            return true;
        }
        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else {
            String merkkijono = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                merkkijono += luvut[i];
                merkkijono += ", ";
            }
            merkkijono += luvut[alkioidenLkm - 1];
            merkkijono += "}";
            return merkkijono;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = luvut[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko c = new IntJoukko();
        for (int i = 0; i < a.mahtavuus(); i++) c.lisaaJoukkoon(a.luvut[i]);
        for (int i = 0; i < b.mahtavuus(); i++) c.lisaaJoukkoon(b.luvut[i]);
        return c;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko c = new IntJoukko();
        for (int i = 0; i < a.mahtavuus(); i++) {
            for (int j = 0; j < b.mahtavuus(); j++) {
                if (a.luvut[i] == b.luvut[j]) c.lisaaJoukkoon(b.luvut[j]);
            }
        }
        return c;
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko c = new IntJoukko();
        for (int i = 0; i < a.mahtavuus(); i++) c.lisaaJoukkoon(a.luvut[i]);
        for (int i = 0; i < b.mahtavuus(); i++) c.poistaLukuJoukosta(b.luvut[i]);
        return c;
    }
        
}
