package com.springsecurity.tutorial.controller;

import com.springsecurity.tutorial.config.PrincipalDetails;
import com.springsecurity.tutorial.model.Board;
import com.springsecurity.tutorial.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

//    @GetMapping("/board")
//    public String boardForm() {
//        return "board/boardForm";
//    }

    @GetMapping("/board")
    public String boardDetail(@RequestParam(required = false) Long id, Model model) {
        if(id == null) {
            model.addAttribute("board", new Board());
        }else {
            Board board = boardService.findBoard(id);
            model.addAttribute("board", board);
        }
        return "board/boardForm";
    }

    @PostMapping("/board")
    public String boardProc(Board board, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        String username = principalDetails.getUsername();
        boardService.글쓰기(board, username);
        return "board/boardList";
    }

    @GetMapping("/board/list")
    public String boardList(Model model, @PageableDefault(size=4) Pageable pageable) {
        Page<Board> boards = boardService.게시글목록(pageable);
        int startPage = max(0, boards.getPageable().getPageNumber()-4);
        int endPage = min(boards.getTotalPages(), boards.getPageable().getPageNumber()+4);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("boards", boards);
        return "board/boardList";
    }
}
