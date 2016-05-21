import org.junit.After;
import org.junit.Before;

/**
 * The test class InitialConditions.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InitialConditions {
    private RandomPlayer automate1;
    private RandomPlayer automate2;

    /**
     * Default constructor for test class InitialConditions
     */
    public InitialConditions() {
    }

    /**
     * Sets up the test fixture.
     * <p>
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        automate1 = new RandomPlayer("George");
        automate2 = new RandomPlayer("Mike", automate1.getMatchBox());

        Player winner = automate1.play(automate2);
        System.out.println(winner.getName());
    }

    /**
     * Tears down the test fixture.
     * <p>
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }
}
