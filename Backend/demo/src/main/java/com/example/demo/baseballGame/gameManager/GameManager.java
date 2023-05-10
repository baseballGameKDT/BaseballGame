package com.example.demo.baseballGame.gameManager;

import com.example.demo.utility.random.CustomRandom;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GameManager {
    private int round = 1;

    private final List<Integer> playerNumberList = new ArrayList<>();
    private final List<Integer> computerNumberList = new ArrayList<>();
    private int round = 1;

    public List<Integer> createComputerNumberList(int numberCount) {
        computerNumberList.clear();

        final int MAX = 9;

        while (computerNumberList.size() < numberCount) {
            int value = CustomRandom.generateNumber(MAX);
            if (computerNumberList.contains(value)) {
                continue;
            }
            computerNumberList.add(value);
        }
        return computerNumberList;
    }

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

        String win = checkWin(level,strike);

        if(win != null){
            result.add(win);
        }

        return result.toString();
    }

    private String checkWin(int level, int strike){
        if(strike == 3){
            round= 1;
            return "승리";
        }

        if(round>level && strike!=3){
            round = 1;
            return "패배";
        }
        return null;
    }
}
