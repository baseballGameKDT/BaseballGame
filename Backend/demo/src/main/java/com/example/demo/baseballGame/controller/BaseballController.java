package com.example.demo.baseballGame.controller;

import com.example.demo.baseballGame.controller.form.*;
import com.example.demo.baseballGame.entity.User;
import com.example.demo.baseballGame.gameManager.GameManager;
import com.example.demo.baseballGame.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/baseball")
public class BaseballController {
    private List<Integer> computerNumberList = new ArrayList<>();

    private List<Integer> playerNumberList = new ArrayList<>();
    private GameManager gameManager = new GameManager();
    private Integer level;
    final UserService userService;
    private User user;
    private Integer bettingPoint;

    @PostMapping("/get-result")
    public ResponseResultForm getGameResult (@RequestBody RequestPlayerNumberForm requestPlayerNumberForm) {

        playerNumberList = requestPlayerNumberForm.getPlayerNumberList();
        List<String> result = gameManager.getResult(computerNumberList, playerNumberList, level, user, bettingPoint);

        return new ResponseResultForm(playerNumberList, result, user.getPoint());
    }

    @PostMapping("/choose-level")
    public void getGameSetting(@RequestBody RequestGameSetForm requestGameSetForm){
        Optional<User> maybeUser = userService.findById(requestGameSetForm.getUser_Id());
        user = maybeUser.get();
        bettingPoint = requestGameSetForm.getBettingPoint();
        computerNumberList = gameManager.createComputerNumberList(requestGameSetForm.getNumberCount());
        level = requestGameSetForm.getLevel();
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
