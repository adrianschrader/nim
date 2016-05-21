import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The test class MatchBoxTest.
 *
 * @author Adrian Schrader
 * @version 1.0.0
 */
public class MatchBoxTest {
    /**
     * Default constructor for test class MatchBoxTest
     */
    public MatchBoxTest() {
    }

    @Test
    public void countTest() {
        // should be caped by upper bound
        MatchBox matchBox1 = new MatchBox(50);
        assertEquals(matchBox1.count(), MatchBox.MATCHES_MAX);

        // should be caped by lower bound
        MatchBox matchBox2 = new MatchBox(5);
        assertEquals(matchBox2.count(), MatchBox.MATCHES_MIN);

        // should otherwise give the supplied value
        MatchBox matchBox3 = new MatchBox(25);
        assertEquals(matchBox3.count(), 25);
    }

    @Test
    public void drawTest() {
        // should draw at least one
        MatchBox matchbox1 = new MatchBox(25);
        matchbox1.draw(0);
        assertEquals(matchbox1.count(), 24);

        // should not draw more than 3
        MatchBox matchbox2 = new MatchBox(25);
        matchbox2.draw(4);
        assertEquals(matchbox2.count(), 22);
    }

    @Test
    public void matchesTest() {
        // should not go below 0
        MatchBox matchbox1 = new MatchBox(10);
        matchbox1.draw(3);
        matchbox1.draw(3);
        matchbox1.draw(3);
        matchbox1.draw(3);
        assertEquals(matchbox1.count(), 0);
    }

    @Test
    public void inspectionTest() {
        // should create reliable copies of the box
        MatchBox original = new MatchBox(10);
        MatchBox copy = original.clone();

        // Manipulate copy and original differently
        original.draw(1);
        copy.draw(3);

        // The objects should be independent
        assertEquals(original.count(), 9);
        assertEquals(copy.count(), 7);
    }
}



