package com.example.demo.baseballGame.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class RequestGameSetForm {

    private final Integer numberCount;
    private final Integer level;
    private final Integer bettingPoint;
    private final Long userId;
}