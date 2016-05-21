
/**
 * The MatchBox is filled once with matches which can be drawn in sets of one to three.
 *
 * @author Adrian Schrader
 * @version 1.0.0
 */
public class MatchBox {
    static final int MATCHES_MIN = 10;
    static final int MATCHES_MAX = 40;

    static final int DRAW_MIN = 1;
    static final int DRAW_MAX = 3;

    private int matches;

    /**
     * Creates a MatchBox with a specific configuration of matches
     *
     * @param matches # of matches in the box (between 10 and 40)
     */
    public MatchBox(int matches) {
        this.matches = this.setBounds(matches, MATCHES_MIN, MATCHES_MAX);
    }

    /**
     *
     */
    public void draw(int n) {
        this.matches -= this.setBounds(n, DRAW_MIN, DRAW_MAX);

        if (this.matches < 0)
            this.matches = 0;
    }

    /**
     * @return # of matches in the box
     */
    public int count() {
        return this.matches;
    }

    private int setBounds(int n, int lower, int upper) {
        return (n < lower) ? lower : (n > upper) ? upper : n;
    }
}
