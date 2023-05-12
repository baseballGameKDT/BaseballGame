package com.example.demo.baseballGame.service;

import com.example.demo.baseballGame.controller.form.RequestAccountForm;
import com.example.demo.baseballGame.entity.User;
import com.example.demo.baseballGame.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

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
}
