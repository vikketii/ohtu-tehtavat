package ohtu.verkkokauppa;

public interface RajapintaPankki {
    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
}
