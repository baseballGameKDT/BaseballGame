package com.example.demo.baseballGame.controller;

import com.example.demo.baseballGame.controller.form.*;
import com.example.demo.baseballGame.gameManager.GameManager;
import com.example.demo.baseballGame.service.GameService;
import com.example.demo.baseballGame.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/baseball")
public class BaseballController {
    private List<Integer> computerNumberList = new ArrayList<>();
    private List<Integer> playerNumberList = new ArrayList<>();
    final private GameManager gameManager = new GameManager();
    private Integer level;
    final private UserService userService;
    final private GameService gameService;
    private Long userId;
    private int bettingPoint;

    @PostMapping("/get-result")
    public ResponseResultForm getGameResult (@RequestBody RequestPlayerNumberForm requestPlayerNumberForm) {

        playerNumberList = requestPlayerNumberForm.getPlayerNumberList();
        List<String> result = gameManager.getResult(computerNumberList, playerNumberList, level);

        if (result.get(2).equals("승리")) {
            gameService.getPoint(userId, bettingPoint, gameManager.getAllot());
        } else if (result.get(2).equals("패배"))  {
            gameService.losePoint(userId, bettingPoint);
        }


        return new ResponseResultForm(playerNumberList, result); // 포인트 넣어서 줘야 함
    }

    @PostMapping("/choose-level")
    public void getGameSetting(@RequestBody RequestGameSetForm requestGameSetForm){
        computerNumberList = gameManager.createComputerNumberList(requestGameSetForm.getNumberCount());
        level = requestGameSetForm.getLevel();

        userId = requestGameSetForm.getUser_Id();
        bettingPoint = requestGameSetForm.getBettingPoint();

        userService.setGameStartPoint(userId, bettingPoint);
        gameManager.setAllocation(requestGameSetForm.getLevel(), requestGameSetForm.getNumberCount());
    }

    @PostMapping("/signup-account")
    public Boolean signupAccount(@RequestBody RequestAccountForm requestAccountForm) {
        return userService.register(requestAccountForm);
    }

    @PostMapping("/login-account")
    public ResponseLoginForm loginAccount(@RequestBody RequestLoginForm requestLoginForm) {
        return userService.login(requestLoginForm);
    }
}
