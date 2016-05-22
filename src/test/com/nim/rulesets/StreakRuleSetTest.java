package com.nim.rulesets;

import com.nim.actors.MatchBox;
import com.nim.actors.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Adrian Schrader
 * @version 1.0.0
 */
public class StreakRuleSetTest {
    public StreakRuleSetTest() {

    }

    @Test
    public void getLength() throws Exception {
        StreakRuleSet rules = new StreakRuleSet(2);
        assertEquals(rules.getLength(), 2);
    }

    @Test
    public void isWinnerDeterminedWithTie() {
        Player player1 = new PlayerImpl();
        Player player2 = new PlayerImpl();
        RuleSet rules = new StreakRuleSet(2);

        rules.registerWin(player1);
        rules.registerWin(player2);
        assertEquals(rules.isWinnerDetermined(), false);
    }

    @Test
    public void isWinnerDeterminedWithBrokenStreak() {
        Player player1 = new PlayerImpl();
        Player player2 = new PlayerImpl();
        RuleSet rules = new StreakRuleSet(2);

        rules.registerWin(player1);
        rules.registerWin(player2);
        rules.registerWin(player1);
        assertEquals(rules.isWinnerDetermined(), false);
    }

    @Test
    public void isWinnerDeterminedWithStreak() {
        Player player1 = new PlayerImpl();
        Player player2 = new PlayerImpl();
        RuleSet rules = new StreakRuleSet(2);

        rules.registerWin(player1);
        rules.registerWin(player2);
        rules.registerWin(player2);
        assertEquals(rules.isWinnerDetermined(), true);
    }

    @Test
    public void isWinnerDeterminedWithHigherStreak() {
        Player player1 = new PlayerImpl();
        Player player2 = new PlayerImpl();
        RuleSet rules = new StreakRuleSet(2);

        rules.registerWin(player2);
        rules.registerWin(player2);
        rules.registerWin(player2);
        assertEquals(rules.isWinnerDetermined(), true);
    }

    @Test
    public void getWinner() {
        Player player1 = new PlayerImpl();
        Player player2 = new PlayerImpl();
        RuleSet rules = new StreakRuleSet(2);

        rules.registerWin(player1);
        rules.registerWin(player2);
        rules.registerWin(player2);
        assertEquals(rules.getWinner(), player2);
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