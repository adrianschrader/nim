package com.nim.rulesets;

import com.nim.actors.Player;

public class StreakRuleSet implements RuleSet {
    private int winningLength;
    private int streakLength;
    private Player streakPlayer;

    public StreakRuleSet(int length) {
        super();
        this.winningLength = length;
        this.streakLength = 0;
        this.streakPlayer = null;
    }

    public int getLength() {
        return this.winningLength;
    }

    @Override
    public void registerWin(Player player) {
        if (this.streakPlayer != null) {
            if (this.streakPlayer.equals(player)) {
                // Begin or continue streak and end
                this.streakLength++;
                return;
            }
        }

        // Break streak and begin a new one
        this.streakLength = 1;
        this.streakPlayer = player;
    }

    @Override
    public boolean isWinnerDetermined() {
        return (streakLength >= winningLength);
    }

    @Override
    public Player getWinner() {
        if (this.isWinnerDetermined())
            return this.streakPlayer;
        else
            return null;
    }
}
