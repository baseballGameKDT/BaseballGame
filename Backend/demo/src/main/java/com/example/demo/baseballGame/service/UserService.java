package com.example.demo.baseballGame.service;

import com.example.demo.baseballGame.controller.form.ResponseLoginForm;
import com.example.demo.baseballGame.controller.form.RequestAccountForm;
import com.example.demo.baseballGame.controller.form.RequestLoginForm;
import com.example.demo.baseballGame.entity.User;

import java.util.Optional;

public interface UserService {
    Boolean register(RequestAccountForm requestAccountForm);

    ResponseLoginForm login(RequestLoginForm requestLoginForm);

    Optional<User> findById(Long userId);
}