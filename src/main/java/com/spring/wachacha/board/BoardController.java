package com.spring.wachacha.board;

import com.spring.wachacha.board.model.BoardDTO;
import com.spring.wachacha.board.model.BoardDomain;
import com.spring.wachacha.board.model.BoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService service;
    @RequestMapping("/list")
    public String list(BoardDTO param, Model model) {
        model.addAttribute("list", service.selBoardList(param));
        return "board/list";
    }

    @RequestMapping("/detail")
    public String detail(BoardDTO param, Model model) {
        BoardDomain data = service.selBoard(param);
        model.addAttribute(data);
        return "board/detail";
    }

    @GetMapping("/writeMod")
    public void writeMod(BoardDTO param, Model model) {
        System.out.println("param = " + param);
        if(param.getIboard() > 0) {
            model.addAttribute("data", service.selBoard(param));
        }
    }

    @PostMapping("/writeMod")
    public String writeModProc(BoardEntity param) {
        int iboard = service.writeMod(param);
        return "redirect:detail?iboard=" + iboard;
    }

    @GetMapping("/delBoard")
    public String delBoard(BoardEntity param) {
        service.delBoard(param);
        return "redirect:list";
    }
}
