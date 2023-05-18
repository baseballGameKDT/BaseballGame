package com.example.demo.baseballGame.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class ResponseLoginForm {

    final private Long userId;
    final private String nickName;
    final private Integer point;

    // final private UUID userToken;
}
