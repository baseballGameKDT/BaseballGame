package com.example.demo.baseballGame.service;

import com.example.demo.baseballGame.controller.form.ResponseLoginForm;
import com.example.demo.baseballGame.controller.form.RequestAccountForm;
import com.example.demo.baseballGame.controller.form.RequestLoginForm;
import com.example.demo.baseballGame.entity.User;
import com.example.demo.baseballGame.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    final UserRepository userRepository;

    @Override
    public Boolean register(RequestAccountForm requestAccountForm) {
        Optional<User> maybeUser = userRepository.findByEmail(requestAccountForm.getEmail());

        if(maybeUser.isPresent()){
            return false;
        }
        userRepository.save(requestAccountForm.toUser());
        return true;
    }

    @Override
    public ResponseLoginForm login(RequestLoginForm requestLoginForm) {
        String email = requestLoginForm.getEmail();
        String password = requestLoginForm.getPassword();

        Optional<User> maybeUser = userRepository.findByEmail(email);

        if(maybeUser.isPresent()) {
            if(password.equals(maybeUser.get().getPassword())) {
                return new ResponseLoginForm(
                        maybeUser.get().getUser_Id(),
                        maybeUser.get().getNickname(),
                        maybeUser.get().getPoint());
            }
        }
        return null;
    }

    @Override
    public void setGameStartPoint(Long userId, Integer bettingPoint) {
        Optional<User> maybeUser = userRepository.findById(userId);

        int currentPoint;
        int gameStartPoint;

        User user;

        if(maybeUser.isPresent()) {
            user = maybeUser.get();

            currentPoint = user.getPoint();
            gameStartPoint = currentPoint - bettingPoint;
            user.setPoint(gameStartPoint);

            userRepository.save(user);
        }
    }
}