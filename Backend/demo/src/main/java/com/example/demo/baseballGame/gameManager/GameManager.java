package com.example.demo.baseballGame.gameManager;

import com.example.demo.baseballGame.entity.User;
import com.example.demo.baseballGame.repository.UserRepository;
import com.example.demo.utility.random.CustomRandom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameManager {
    private int round = 1;
    private int winCondition;
    private final List<Integer> computerNumberList = new ArrayList<>();
    private double allot;
    private User user;
    private int resultPoint;
    final UserRepository userRepository;

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

    public List<String> getResult (List<Integer> computerNumberList, List<Integer> playerNumberList, int level, Long userId, int bettingPoint) {
        final List<String> result = new ArrayList<>();

        int strike = 0;
        int ball = 0;
        int NUMBER_COUNT = computerNumberList.size();

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

            if(win.equals("승리")) {
                getPoint(userId, bettingPoint, allot);
            }
            if(win.equals("패배")) {
                losePoint(userId, bettingPoint);
            }
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


    public void setAllocation(Integer level, Integer numberCount) {
        if(level == 3 && numberCount == 10) {
            allot = 1.5;
        }
        if(level == 4 && numberCount == 20) {
            allot = 2;
        }
        if(level == 4 && numberCount == 10) {
            allot = 3;
        }
    }
    public Integer getPoint(Long userId, int bettingPoint, double allot) {
        Optional<User> maybeUser = userRepository.findById(userId);
        if(maybeUser.isPresent()) {
            user = maybeUser.get();
        }
        int currentPoint = user.getPoint();

        if(allot == 1.5){
            resultPoint = (int)(currentPoint + (1.5) * bettingPoint);
        }
        if(allot == 2){
            resultPoint = (currentPoint + (2) * bettingPoint);
        }
        if(allot == 3){
            resultPoint = (currentPoint + (3) * bettingPoint);
        }
        user.setPoint(resultPoint);
        userRepository.save(user);

        return user.getPoint();
    }

    public Integer losePoint(Long userId, int bettingPoint) {
        Optional<User> maybeUser = userRepository.findById(userId);
        if(maybeUser.isPresent()) {
            user = maybeUser.get();
        }
        int currentPoint = user.getPoint();
        resultPoint = currentPoint - bettingPoint;

        user.setPoint(resultPoint);
        userRepository.save(user);

        return user.getPoint();
    }

}