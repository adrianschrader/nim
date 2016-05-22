package com.nim.actors;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Adrian Schrader
 * @version 1.0.0
 */
public class AIPlayerTest {

    @Test
    public void drawMatches() throws Exception {
        AIPlayer player = new AIPlayer("");
        MatchBox matchBox = new MatchBox(15);
        assertEquals(player.drawMatches(matchBox), 2);
    }

    @Test
    public void generateMatchBox() throws Exception {
        AIPlayer player = new AIPlayer("");
        MatchBox matchBox = player.generateMatchBox();

        // The number of matches should be a key number
        assertEquals(player.getNextKeyNumber(matchBox.count()), matchBox.count());
    }

    @Test
    public void getNextKeyNumbers() throws Exception {
        AIPlayer player = new AIPlayer("");
        assertEquals(player.getNextKeyNumber(14), 13);
        assertEquals(player.getNextKeyNumber(10), 9);
        assertEquals(player.getNextKeyNumber(9), 9);
    }
}