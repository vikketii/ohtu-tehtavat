package ohtu.verkkokauppa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Kauppa {

    @Autowired
    private RajapintaVarasto rajapintaVarasto;
    @Autowired
    private RajapintaPankki rajapintaPankki;
    @Autowired
    private RajapintaViitegeneraattori rajapintaViitegeneraattori;
    private Ostoskori ostoskori;
    private String kaupanTili;

    public Kauppa() {
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = rajapintaVarasto.haeTuote(id);
        rajapintaVarasto.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (rajapintaVarasto.saldo(id)>0) {
            Tuote t = rajapintaVarasto.haeTuote(id);
            ostoskori.lisaa(t);
            rajapintaVarasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = rajapintaViitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return rajapintaPankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
