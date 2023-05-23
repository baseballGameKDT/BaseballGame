package com.example.demo.baseballGame.service;

import com.example.demo.baseballGame.entity.User;
import com.example.demo.baseballGame.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService{

    final private UserRepository userRepository;
    int resultPoint;
    private User user;

    @Override
    public Integer getPoint(Long userId, int bettingPoint, double allot) {
        Optional<User> maybeUser = userRepository.findById(userId);
        if(maybeUser.isPresent()) {
            user = maybeUser.get();
        }
        int currentPoint = user.getPoint();

        if(allot == 1.5){
            resultPoint = (int)(currentPoint + (1.5) * bettingPoint);
        }
        if(allot == 2){
            resultPoint = (currentPoint + (2) * bettingPoint);
        }
        if(allot == 3){
            resultPoint = (currentPoint + (3) * bettingPoint);
        }
        user.setPoint(resultPoint);
        userRepository.save(user);

        return user.getPoint();
    }

    @Override
    public Integer losePoint(Long userId, int bettingPoint) {
        Optional<User> maybeUser = userRepository.findById(userId);
        if(maybeUser.isPresent()) {
            user = maybeUser.get();
        }
        int currentPoint = user.getPoint();
        resultPoint = currentPoint - bettingPoint;

        user.setPoint(resultPoint);
        userRepository.save(user);

        return user.getPoint();
    }
}
