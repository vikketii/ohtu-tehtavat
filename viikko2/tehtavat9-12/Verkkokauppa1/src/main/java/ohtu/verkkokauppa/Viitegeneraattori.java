package ohtu.verkkokauppa;

public class Viitegeneraattori implements RajapintaViitegeneraattori {

    private static RajapintaViitegeneraattori instanssi;

    public static RajapintaViitegeneraattori getInstance() {
        if (instanssi == null) {
            instanssi = new Viitegeneraattori();
        }

        return instanssi;
    }
    
    private int seuraava;
    
    private Viitegeneraattori(){
        seuraava = 1;    
    }
    
    @Override
    public int uusi(){
        return seuraava++;
    }
}
