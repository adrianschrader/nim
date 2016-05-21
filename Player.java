
/**
 * Abstract class Player - write a description of the class here
 *
 * @author Adrian Schrader
 * @version 1.0.0
 */
public abstract class Player {

    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public final String getName() {
        return this.name;
    }

    public final Player play(Player nextPlayer) {
        // The other player may choose the MatchBox size
        MatchBox matchBox = nextPlayer.generateMatchBox();

        // Player 1 may begin
        return this.play(nextPlayer, matchBox);
    }

    public final Player play(Player nextPlayer, MatchBox matchBox) {
        // If the other player had to take the last match, you have won.
        if (matchBox.count() == 0)
            return this;

        // Let the player make his decision
        int numberOfMatches = this.drawMatches(matchBox.clone());

        // Make sure that the player can invoke the draw(int n) method just once
        // Validation happens in the MatchBox class
        matchBox.draw(numberOfMatches);

        System.out.println(this.getName() + " " + matchBox.count());

        // End the turn and return the result
        return nextPlayer.play(this, matchBox);
    }

    /**
     * Determines the number of matches that should be drawn by the play method. Is implemented by the actual game logic
     * in the subclasses.
     *
     * @param box copy of the matchbox for inspection
     * @return # of matches to remove
     */
    protected abstract int drawMatches(final MatchBox box);

    /**
     * At the begin of a round,
     *
     * @return
     */
    public abstract MatchBox generateMatchBox();
}
