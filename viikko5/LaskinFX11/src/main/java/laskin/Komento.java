package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {
    protected TextField tuloskentta;
    protected TextField syotekentta;
    protected Button nollaa;
    protected Button undo;
    protected Sovelluslogiikka sovellus;
    private int edellinenArvo;

    public Komento(TextField tulostuskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tulostuskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    public void suorita() {
        int arvo = 0;

        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }

        edellinenArvo = sovellus.tulos();
        laske(arvo);

        int laskunTulos = sovellus.tulos();

        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);

        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    };

    public void peru() {
        sovellus.nollaa();
        sovellus.plus(edellinenArvo);
        syotekentta.setText("");
        tuloskentta.setText("" + edellinenArvo);
        if (edellinenArvo==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(true);
    };

    protected abstract void laske(int arvo);
}
