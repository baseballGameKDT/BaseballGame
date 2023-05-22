package com.example.demo.baseballGame.gameManager;

import com.example.demo.baseballGame.entity.User;
import com.example.demo.utility.random.CustomRandom;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GameManager {
    private int round = 1;
    private int winCondition;
    private final List<Integer> computerNumberList = new ArrayList<>();
    private int NUMBER_COUNT = 0;
    private Integer resultPoint = 0;
    private String allot;

    public List<Integer> createComputerNumberList(int numberCount) {
        computerNumberList.clear();
        round = 1;
        winCondition = numberCount;

        final int MIN = 1;
        final int MAX = 9;

        while (computerNumberList.size() < numberCount) {
            int value = CustomRandom.generateNumber(MIN, MAX);
            if (computerNumberList.contains(value)) {
                continue;
            }
            computerNumberList.add(value);
        }
        return computerNumberList;
    }

    public List<String> getResult (List<Integer> computerNumberList, List<Integer> playerNumberList, int level, User user, int bettingPoint) {
        final List<String> result = new ArrayList<>();

        setBet(NUMBER_COUNT, level);

        int strike = 0;
        int ball = 0;
        NUMBER_COUNT = computerNumberList.size();

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

        result.add(round + "Round " + strike + "S " + ball + "B");

        log.info("round: " + round + ", strike: " + strike + ", ball: " + ball);
        round++;

        String win = checkWin(level,strike);

        if(win != null){
            result.add(win);
            result.add(computerNumberList.toString());
            calculatePoint(win, user, bettingPoint);
        }

        return result;
    }

    private String checkWin(int level, int strike){
        if(strike == winCondition){
            return "승리";
        }

        if(round>level && strike!=winCondition){
            return "패배";
        }
        return null;
    }

    private String setBet(int NUMBER_COUNT, int level) {
        if(NUMBER_COUNT == 3 && level == 10) {
            allot = "easy";
        }
        if(NUMBER_COUNT == 4 && level == 20) {
            allot = "normal";
        }
        if(NUMBER_COUNT == 4 && level == 10) {
            allot = "hard";
        }
        return allot;
    }
    private void calculatePoint (String win, User user, int bettingPoint) {
        if(win.equals("승리")) {
            switch (allot) {
                case "easy":
                    resultPoint = user.getPoint() - bettingPoint + ( 2 * bettingPoint );
                    break;
                case "normal":
                    resultPoint = user.getPoint() - bettingPoint + ( 3 * bettingPoint );
                    break;
                case "hard":
                    resultPoint = user.getPoint() - bettingPoint + ( 4 * bettingPoint );
                    break;
            }
            user.setPoint(resultPoint);
        }
        if(win.equals("패배")) {
            switch (allot) {
                case "easy":
                    resultPoint = user.getPoint() - bettingPoint - ( 2 * bettingPoint );
                    break;
                case "normal":
                    resultPoint = user.getPoint() - bettingPoint - ( 3 * bettingPoint );
                    break;
                case "hard":
                    resultPoint = user.getPoint() - bettingPoint - ( 4 * bettingPoint );
                    break;
            }
            user.setPoint(resultPoint);
        }
    }
}
