package com.example.demo.board.service;

import java.util.List;
import java.util.UUID;

import com.example.demo.board.vo.BoardVo;
import com.example.demo.common.exception.BizException;

public interface BoardService {

  List<BoardVo.ListResponse> getBoards(BoardVo.ListRequest param);

  BoardVo.DetailResponse getBoard(UUID id) throws BizException;
  
  void addBoard(BoardVo.CreateRequest param);

  void updateBoard(UUID id, BoardVo.CreateRequest param) throws BizException;

  void deleteBoard(UUID id) throws BizException;
}
