package com.example.demo.baseballGame.service;

import com.example.demo.baseballGame.controller.form.RequestAccountForm;

public interface UserService {
    Boolean register(RequestAccountForm requestAccountForm);
}