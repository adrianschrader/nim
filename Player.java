
/**
 * Abstract class Player - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Player {
    // instance variables - replace the example below with your own
    private final String name;
    private final MatchBox matchBox;

    public Player(String name) {
        this.name = name;
        this.matchBox = new MatchBox(MatchBox.MATCHES_MAX);
    }

    public Player(String name, MatchBox box) {
        this.name = name;
        this.matchBox = box;
    }

    public final String getName() {
        return this.name;
    }

    public final MatchBox getMatchBox() {
        return this.matchBox;
    }

    public final Player play(Player nextPlayer) {
        if (this.matchBox.count() == 1)
            return nextPlayer;

        // Let the player make his decision
        this.drawMatches(this.matchBox);

        // End the turn and return the result
        return nextPlayer.play(this);
    }

    protected abstract void drawMatches(MatchBox matchBox);
}
