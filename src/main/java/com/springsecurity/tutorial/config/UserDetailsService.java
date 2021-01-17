package com.springsecurity.tutorial.config;

import com.springsecurity.tutorial.model.User;
import com.springsecurity.tutorial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> {
                    throw new UsernameNotFoundException("해당 사용자는 찾을 수 없습니다. " + username);
                }
        );
        // 시큐리티 세션에 유저정보 저장
        return new UserDetailsImpl(user);
    }
}
