package com.nim;

import com.nim.actors.CmdPlayer;
import com.nim.actors.Player;
import com.nim.actors.RandomPlayer;
import com.nim.rulesets.BestOfRuleSet;

public class Main {

    public static void main(String[] args) {
        Player aiPlayer = new RandomPlayer("Der Computer");
        Player cmdPlayer = new CmdPlayer("Du");
        Player winner = aiPlayer.playGame(cmdPlayer, new BestOfRuleSet(3));

        System.out.println(winner.getName() + " hat im Verfahren BestOfThree gewonnen");
    }
}
