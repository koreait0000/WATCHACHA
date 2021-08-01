package com.spring.wachacha.board;

import com.spring.wachacha.board.model.BoardDTO;
import com.spring.wachacha.board.model.BoardDomain;
import com.spring.wachacha.board.model.BoardEntity;
import com.spring.wachacha.config.security.IAuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper mapper;
    private final IAuthenticationFacade auth;

    public List<BoardDomain> selBoardList(BoardDTO param) {
        param.setIuser(auth.getLoginUserPk());

        return mapper.selBoardList(param);
    }

    public BoardDomain selBoard(BoardDTO param) {
        return mapper.selBoard(param);
    }


    public int writeMod(BoardEntity param) {
        param.setIuser(auth.getLoginUserPk());

        if(param.getIboard() == 0) { //등록
            mapper.insBoard(param);
        } else { //수정
            mapper.updBoard(param);
        }
        return param.getIboard();
    }

    public int delBoard(BoardEntity param) {
        param.setIuser(auth.getLoginUserPk());
        return mapper.delBoard(param);
    }

}
