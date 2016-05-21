
/**
 * Write a description of class AutomatedPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RandomPlayer extends Player {
    public RandomPlayer(String name) {
        super(name);
    }

    public RandomPlayer(String name, MatchBox matchBox) {
        super(name, matchBox);
    }

    protected void drawMatches(MatchBox box) {
        box.draw((int) Math.floor(Math.random() * 3.0d + 1.0d));
    }

    public MatchBox generateMatchBox() {
        return new MatchBox(12);
    }
}
