package com.example.demo.baseballGame.controller.form;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class ResponseResultForm {
    private List<Integer> playerNumberList;
    private List<String> result;
    private Integer playerPoint;

    public ResponseResultForm(List<Integer> playerNumberList, List<String> result, Integer playerPoint) {
        this.playerNumberList = playerNumberList;
        this.result = result;
        this.playerPoint = playerPoint;
    }
}
