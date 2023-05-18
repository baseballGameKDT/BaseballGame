package com.example.demo.baseballGame.controller.form;

import com.example.demo.baseballGame.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestAccountForm {

    private String email;
    private String password;
    private String nickname;

    public User toUser(){
        return new User(email, password, nickname);
    }
}
