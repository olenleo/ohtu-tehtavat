package ohtuesimerkki;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


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
    public void searchLoytaaPelaajanListalta(){

        Player pelaaja = stats.search("Kurri");
        String etsittava = "Kurri";

        assertEquals(etsittava, pelaaja.getName());

    }
    @Test
    public void olematontaPelaajaaPalauttaaNull(){
        Player pelaaja = stats.search("MikkoMallikas");
        assertNull(pelaaja);
    }

    @Test
    public void teaminKokoOikein() {
        assertEquals(1, stats.team("PIT").size());
    }
    @Test
    public void teamissaOikeaPelaaja() {
        assertEquals("Lemieux", stats.team("PIT").get(0).getName());
       
    }
    @Test
    public void topScorerPalauttaaOikein() {
       List<Player> scores = new ArrayList<>();
       scores = stats.topScorers(3);
       assertEquals("Gretzky", scores.get(0).getName());
    }

}
