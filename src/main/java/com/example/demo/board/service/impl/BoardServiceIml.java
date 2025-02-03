package com.example.demo.board.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.board.entity.BoardEntity;
import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.repository.BoardRepository;
import com.example.demo.board.service.BoardService;
import com.example.demo.board.vo.BoardVo;
import com.example.demo.common.constant.ErrorCode;
import com.example.demo.common.exception.BizException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceIml implements BoardService {
  private final BoardRepository boardRepository;
  private final BoardMapper boardMapper;

  @Override
  public List<BoardVo.ListResponse> getBoards(BoardVo.ListRequest param) {
    List<BoardEntity> boards = boardRepository.findAll();
    // return boards.stream().map(e -> BoardVo.ListResponse.builder()
    //     .id(e.getId().toString())
    //     .delYn(e.isDelYn())
    //     .order(e.getOrder())
    //     .title(e.getTitle(param.getLangCode()))
    //     .build())
    //     .collect(Collectors.toList());
    return boardMapper.toListResponse(boards, param.getLangCode());
  }

  @Override
  public BoardVo.DetailResponse getBoard(UUID id) throws BizException {
    BoardEntity entity = boardRepository.findById(id)
        .orElseThrow(() -> new BizException(ErrorCode.DATA_NOT_FOUND_ERROR));
    // return BoardVo.DetailResponse.builder()
    //     .id(entity.getId().toString())
    //     .delYn(entity.isDelYn())
    //     .order(entity.getOrder())
    //     .titles(entity.getTitles().stream()
    //         .map(e -> BoardVo.BoardTitle.builder()
    //             .langCode(e.getLangCode())
    //             .title(e.getTitle())
    //             .defaultYn(e.isDefaultYn())
    //             .build())
    //         .collect(Collectors.toList()))
    //     .build();
    return boardMapper.toDetailResponse(entity);
  }

  @Override
  public void addBoard(BoardVo.CreateRequest param) {
    // BoardEntity entity = new BoardEntity();
    // entity.setDelYn(false);
    // entity.setOrder(param.getOrder());

    // List<BoardTitleEntity> list = new ArrayList<>();

    // param.getTitles().forEach(
    //     e -> list.add(BoardTitleEntity.builder()
    //         .langCode(e.getLangCode())
    //         .title(e.getTitle())
    //         .defaultYn(e.isDefaultYn())
    //         .board(entity)
    //         .build()));
    // entity.setTitles(list);

    BoardEntity entity = boardMapper.toEntity(param);
    boardRepository.save(entity);
  }

  @Override
  public void updateBoard(UUID id, BoardVo.CreateRequest param) throws BizException {
    BoardEntity entity = boardRepository.findById(id)
        .orElseThrow(() -> new BizException(ErrorCode.DATA_NOT_FOUND_ERROR));

    // entity.setDelYn(false);
    // entity.setOrder(0);
    // entity.getTitles().forEach(e -> {
    //   param.getTitles().stream().filter(ne -> e.getLangCode().equals(ne.getLangCode())).findFirst()
    //       .ifPresent(ne -> {
    //         e.setTitle(ne.getTitle());
    //         e.setDefaultYn(ne.isDefaultYn());
    //       });
    // });

    boardMapper.update(entity, param);
    boardRepository.save(entity);
  }

  @Override
  public void deleteBoard(UUID id) throws BizException {
    BoardEntity entity = boardRepository.findById(id)
        .orElseThrow(() -> new BizException(ErrorCode.DATA_NOT_FOUND_ERROR));
    entity.setDelYn(true);
    boardRepository.save(entity);
  }

}
