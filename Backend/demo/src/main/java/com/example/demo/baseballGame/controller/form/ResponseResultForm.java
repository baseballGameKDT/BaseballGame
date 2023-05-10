package com.example.demo.baseballGame.controller.form;

import lombok.ToString;

import java.util.List;

@ToString
public class ResponseResultForm {
    private List<Integer> playerNumberList;
    private String result;

    public ResponseResultForm(List<Integer> playerNumberList, String result) {
        this.playerNumberList = playerNumberList;
        this.result = result;
    }
}
