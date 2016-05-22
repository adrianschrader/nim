package com.nim.rulesets;

import com.nim.actors.Player;

public interface RuleSet {
    void registerWin(Player player);

    boolean isWinnerDetermined();

    Player getWinner();
}
