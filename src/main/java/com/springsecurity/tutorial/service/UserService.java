package com.springsecurity.tutorial.service;

import com.springsecurity.tutorial.model.User;
import com.springsecurity.tutorial.model.UserRole;
import com.springsecurity.tutorial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void 회원가입(User user) {
        String originPWD = user.getPassword();
        String encPWD = bCryptPasswordEncoder.encode(originPWD);
        user.setPassword(encPWD);
        user.setEnabled(true);
        user.setUserRole(UserRole.USER);
        userRepository.save(user);
    }
}
