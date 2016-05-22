package com.nim.actors;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    public PlayerTest() {

    }

    @Test
    public void getName() throws Exception {
        Player player = new PlayerImpl();
        assertEquals(player.getName(), "John Doe");
    }

    @Test
    public void playDeterminesWinner() throws Exception {
        Player playerA = new PlayerImpl(),
                playerB = new PlayerImpl();
        MatchBox matchBox = new MatchBox(10);

        // Draw until there is one match in the box
        matchBox.draw(3);
        matchBox.draw(3);
        matchBox.draw(3);

        Player winner = playerA.play(matchBox, playerB);
        assertEquals(winner, playerB);
    }

    @Test
    public void playRemovesMatches() throws Exception {
        Player playerA = new PlayerImpl();
        MatchBox matchBox = new MatchBox(10);

        playerA.play(matchBox);
        assertEquals(matchBox.count(), 9);
    }
}

class PlayerImpl extends Player {
    public PlayerImpl() {
        super("John Doe");
    }

    @Override
    protected int drawMatches(MatchBox box) {
        return 1;
    }

    @Override
    public MatchBox generateMatchBox() {
        return new MatchBox(10);
    }
}