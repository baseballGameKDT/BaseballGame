package com.example.demo.baseballGame.controller.form;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class ResponseResultForm {
    private List<Integer> playerNumberList;
    private String result;

    public ResponseResultForm(List<Integer> playerNumberList, String result) {
        this.playerNumberList = playerNumberList;
        this.result = result;
    }
}
