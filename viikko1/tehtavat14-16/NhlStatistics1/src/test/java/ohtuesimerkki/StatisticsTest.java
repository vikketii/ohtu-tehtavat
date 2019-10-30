package ohtuesimerkki;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void search() {
        Player foundPlayer = stats.search("Semenko");
        Player semenko = new Player("Semenko", "EDM", 4, 12);
        assertEquals(semenko.getName(), foundPlayer.getName());

        Player noPlayer = stats.search("null");
        assertNull(noPlayer);
    }

    @Test
    public void team() {
        List<Player> foundPlayers = stats.team("EDM");
        String[] foundNames = new String[3];
        int n = 0;
        for (Player p : foundPlayers) {
            foundNames[n] = p.getName();
            n++;
        }
        String[] edm = {"Semenko", "Kurri", "Gretzky"};
        assertArrayEquals(edm, foundNames);

        List<Player> noPlayers = stats.team("ASDF");
        assertTrue(noPlayers.isEmpty());
    }

    @Test
    public void topScorers() {
        List<Player> foundTop3 = stats.topScorers(2);
        String[] foundNames = new String[3];
        int n = 0;
        for (Player p : foundTop3) {
            foundNames[n] = p.getName();
            n++;
        }
        String[] top3 = {"Gretzky", "Lemieux", "Yzerman"};
        assertArrayEquals(top3, foundNames);
    }
}