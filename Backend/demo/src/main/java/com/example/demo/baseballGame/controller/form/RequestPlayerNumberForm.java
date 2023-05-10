package com.example.demo.baseballGame.controller.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class RequestPlayerNumberForm {
    private List<Integer> playerNumberList;
}
