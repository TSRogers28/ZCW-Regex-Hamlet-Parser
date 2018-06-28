import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String leon = hamletParser.changeWord("Hamlet", "Leon");

        int expected = hamletParser.findWord(hamletText , "Hamlet");
        int actual = hamletParser.findWord(leon , "Leon");

        System.out.println(leon);

        assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String leon = hamletParser.changeWord("Horatio", "Tariq");

        int expected = hamletParser.findWord(hamletText , "Horatio");
        int actual = hamletParser.findWord(leon , "Tariq");

        System.out.println(leon);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
        int expected = 158;
        int actual = hamletParser.findWord(hamletText,"Horatio");
        assertEquals(expected, actual);
    }

    @Test
    public void testFindHamlet() {
        int expected = 472;
        int actual = hamletParser.findWord(hamletText,"Hamlet");
        assertEquals(expected, actual);
    }
}