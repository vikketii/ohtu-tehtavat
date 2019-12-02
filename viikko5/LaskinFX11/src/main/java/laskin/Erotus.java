package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Komento {
    public Erotus(TextField tulostuskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tulostuskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    protected void laske(int arvo) {
        sovellus.miinus(arvo);
    }
}
