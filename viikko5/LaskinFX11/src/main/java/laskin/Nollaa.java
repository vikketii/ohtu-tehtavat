package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {
    public Nollaa(TextField tulostuskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tulostuskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    protected void laske(int arvo) {
        sovellus.nollaa();
    }
}
