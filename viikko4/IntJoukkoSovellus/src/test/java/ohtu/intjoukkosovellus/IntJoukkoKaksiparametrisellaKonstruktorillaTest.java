
package ohtu.intjoukkosovellus;

import org.junit.Before;

public class IntJoukkoKaksiparametrisellaKonstruktorillaTest extends IntJoukkoTest {
    
    @Before
    public void setUp() {
        joukko = new IntJoukko(4, 2);
        joukko.lisaaJoukkoon(10);
        joukko.lisaaJoukkoon(3);
    }
}
