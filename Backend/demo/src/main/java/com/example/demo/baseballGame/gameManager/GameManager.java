package com.example.demo.baseballGame.gameManager;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GameManager {
    private int round = 1;

    public String getResult (List<Integer> computerNumberList, List<Integer> playerNumberList, int level) {
        final List<String> result = new ArrayList<>();

        int strike = 0;
        int ball = 0;
        final int NUMBER_COUNT = computerNumberList.size();

        for(int i = 0; i < NUMBER_COUNT; i++) {
            if(computerNumberList.contains(playerNumberList.get(i))) {
                if(playerNumberList.get(i) == computerNumberList.get(i)) {
                    strike++;
                }
                else{
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
