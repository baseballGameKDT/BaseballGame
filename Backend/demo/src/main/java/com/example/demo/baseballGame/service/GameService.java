package com.example.demo.baseballGame.service;

import com.example.demo.baseballGame.entity.User;

public interface GameService {
    Integer getPoint(Long userId, int bettingPoint, double allot);

    Integer losePoint(Long userId, int bettingPoint);
}
