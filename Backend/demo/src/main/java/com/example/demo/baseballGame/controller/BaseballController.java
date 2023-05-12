package com.example.demo.baseballGame.controller;

import com.example.demo.baseballGame.controller.form.RequestAccountForm;
import com.example.demo.baseballGame.controller.form.RequestGameSetForm;
import com.example.demo.baseballGame.controller.form.RequestPlayerNumberForm;
import com.example.demo.baseballGame.controller.form.ResponseResultForm;
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

    @PostMapping("/get-result")
    public ResponseResultForm getGameResult (@RequestBody RequestPlayerNumberForm requestPlayerNumberForm) {

        playerNumberList = requestPlayerNumberForm.getPlayerNumberList();
        List<String> result = gameManager.getResult(computerNumberList, playerNumberList, level);

        return new ResponseResultForm(playerNumberList, result);
    }

    @PostMapping("/choose-level")
    public void getGameSetting(@RequestBody RequestGameSetForm requestGameSetForm){
        computerNumberList = gameManager.createComputerNumberList(requestGameSetForm.getNumberCount());
        level = requestGameSetForm.getLevel();
    }

    @PostMapping("/signup-account")
    public Boolean signupAccount(@RequestBody RequestAccountForm requestAccountForm) {
        return userService.register(requestAccountForm);
    }
}
