package com.springsecurity.tutorial.service;

import com.springsecurity.tutorial.model.Board;
import com.springsecurity.tutorial.model.User;
import com.springsecurity.tutorial.repository.BoardRepository;
import com.springsecurity.tutorial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public void 글쓰기(Board board, String username){
        Optional<User> findUser = userRepository.findByUsername(username);
        board.setUser(findUser.get());
        boardRepository.save(board);
    }

    public Page<Board> 게시글목록(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    public Board findBoard(Long id) {
        return boardRepository.findById(id).get();
    }
}
