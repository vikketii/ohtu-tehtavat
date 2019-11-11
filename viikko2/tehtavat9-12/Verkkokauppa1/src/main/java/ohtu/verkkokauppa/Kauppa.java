package ohtu.verkkokauppa;

public class Kauppa {

    private RajapintaVarasto rajapintaVarasto;
    private RajapintaPankki rajapintaPankki;
    private Ostoskori ostoskori;
    private RajapintaViitegeneraattori rajapintaViitegeneraattori;
    private String kaupanTili;

    public Kauppa(RajapintaVarasto rajapintaVarasto, RajapintaPankki rajapintaPankki, RajapintaViitegeneraattori rajapintaViitegeneraattori) {
        this.rajapintaVarasto = rajapintaVarasto;
        this.rajapintaPankki = rajapintaPankki;
        this.rajapintaViitegeneraattori = rajapintaViitegeneraattori;
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
