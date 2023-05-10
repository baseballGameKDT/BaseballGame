package com.example.demo.baseballGame.gameManager;

import com.example.demo.utility.random.CustomRandom;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GameManager {
    private final List<Integer> playerNumberList = new ArrayList<>();
    private final List<Integer> computerNumberList = new ArrayList<>();
    private int round = 1;



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
