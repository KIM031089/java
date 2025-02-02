package com.example.demo.board.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.service.BoardService;
import com.example.demo.board.vo.BoardVo;
import com.example.demo.board.vo.BoardVo.DetailResponse;
import com.example.demo.common.exception.BizException;
import com.example.demo.common.vo.CommonResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardController {

  private final BoardService boardService;

  @GetMapping("/boards")
  public List<BoardVo.ListResponse> getBoards(@RequestParam(name = "langCode") String langCode) {
    return boardService.getBoards(BoardVo.ListRequest.builder().langCode(langCode).build());
  }

  @GetMapping("/board/{id}")
  public DetailResponse getBoard(@PathVariable("id") UUID id) throws BizException {
    return boardService.getBoard(id);
  }

  @PostMapping("/board")
  public CommonResponse addBoard(@RequestBody @Valid BoardVo.CreateRequest param) {
    boardService.addBoard(param);
    return new CommonResponse();
  }

  @PostMapping("/board/{id}")
  public CommonResponse updateBoard(@RequestBody @Valid BoardVo.CreateRequest param, @PathVariable("id") String id)
      throws BizException {
    boardService.updateBoard(UUID.fromString(id), param);
    return new CommonResponse();
  }

  @DeleteMapping("/board/{id}")
  public CommonResponse deleteBoard(@PathVariable("id") String id) throws BizException {
    boardService.deleteBoard(UUID.fromString(id));
    return new CommonResponse();
  }

}
