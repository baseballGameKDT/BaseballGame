package com.example.demo.baseballGame.gameManager;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GameManager {
    private final List<Integer> playerNumberList = new ArrayList<>();
    private int round = 1;

    public List<Integer> getplayerNumberList (int playerNumber) {
        playerNumberList.clear();

        playerNumberList.add(playerNumber / 100);
        playerNumberList.add((playerNumber % 100) / 10);
        playerNumberList.add(playerNumber % 10);

        return playerNumberList;
    }

    public String getResult (List<Integer> computerNumberList, int level) {
        final List<String> result = new ArrayList<>();

        int strike = 0;
        int ball = 0;

        for(int i = 0; i < computerNumberList.size(); i++) {
            if(computerNumberList.get(i) == playerNumberList.get(i)) {
                strike++;
            }
        }
        for(int i = 0; i < computerNumberList.size(); i++) {
            for(int j = 0; j < computerNumberList.size(); j++) {
                if(computerNumberList.get(i) == playerNumberList.get(j)
                        && computerNumberList.get(j) != playerNumberList.get(j)) {
                    ball++;
                }
            }
        }

        result.add(round + "Round");
        result.add(strike + "S");
        result.add(ball + "B");

        log.info("round: " + round + ", strike: " + strike + ", ball: " + ball);
        round++;

        return result.toString();
    }
}
