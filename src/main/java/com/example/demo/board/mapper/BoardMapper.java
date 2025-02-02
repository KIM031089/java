package com.example.demo.board.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.util.CollectionUtils;

import com.example.demo.board.entity.BoardEntity;
import com.example.demo.board.entity.BoardTitleEntity;
import com.example.demo.board.vo.BoardVo;

@Mapper
public interface BoardMapper {
  List<BoardVo.ListResponse> toListResponse(List<BoardEntity> boards, @Context String langCode);

  @AfterMapping
  default void boardEntityToListResponse(
      @MappingTarget BoardVo.ListResponse.ListResponseBuilder listResponse,
      BoardEntity boardEntity,
      @Context String langCode) {
    listResponse.title(boardEntity.getTitle(langCode));
  }

  BoardVo.DetailResponse toDetailResponse(BoardEntity board);

  BoardEntity toEntity(BoardVo.CreateRequest createRequest);

  @AfterMapping
  default void makeRelation(
      @MappingTarget BoardEntity boardEntity,
      BoardVo.CreateRequest createRequest) {

    List<BoardTitleEntity> titles = boardEntity.getTitles();

    if (!CollectionUtils.isEmpty(titles)) {
      titles.forEach(e -> e.setBoard(boardEntity));
    }
  }

  BoardEntity update(@MappingTarget BoardEntity boardEntity, BoardVo.CreateRequest vo);

}
