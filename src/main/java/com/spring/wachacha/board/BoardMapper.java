package com.spring.wachacha.board;

import com.spring.wachacha.board.model.BoardDTO;
import com.spring.wachacha.board.model.BoardDomain;
import com.spring.wachacha.board.model.BoardEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BoardMapper {
    int insBoard(BoardEntity param);
    List<BoardDomain> selBoardList(BoardDTO param);
    BoardDomain selBoard(BoardDTO param);
    int updBoard(BoardEntity param);
    int delBoard(BoardEntity param);
}
