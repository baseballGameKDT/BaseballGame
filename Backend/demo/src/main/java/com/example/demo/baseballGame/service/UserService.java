package com.example.demo.baseballGame.service;

import com.example.demo.baseballGame.controller.form.ResponseLoginForm;
import com.example.demo.baseballGame.controller.form.RequestAccountForm;
import com.example.demo.baseballGame.controller.form.RequestLoginForm;

public interface UserService {
    Boolean register(RequestAccountForm requestAccountForm);

    ResponseLoginForm login(RequestLoginForm requestLoginForm);

    void setGameStartPoint(Long userId, Integer bettingPoint);
}