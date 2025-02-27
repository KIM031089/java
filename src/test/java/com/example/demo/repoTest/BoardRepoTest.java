package com.example.demo.repoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.board.entity.BoardEntity;
import com.example.demo.board.repository.BoardRepository;

import jakarta.transaction.Transactional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BoardRepoTest {
  @Autowired
  private BoardRepository boardRepository;

  @Test
  void saveTest() {
    // given
    BoardEntity boardEntity = new BoardEntity();
    boardEntity.setDelYn(true);
    boardEntity.setOrder(1);
    // when
    BoardEntity savedBoardEntity = boardRepository.save(boardEntity);

    assertEquals(boardEntity, savedBoardEntity);
  }
  
  @Test
  @Transactional
  void findAllTest() {
    // given
    BoardEntity boardEntity1 = makeBoardEntity(true, 1);
    BoardEntity boardEntity2 = makeBoardEntity(true, 2);

    // when
    List<BoardEntity> boardList = boardRepository.findAll();

    assertEquals(2, boardList.size());
    assertEquals(boardEntity1.getId(), boardList.get(0).getId());
    assertEquals(boardEntity2.getId(), boardList.get(1).getId());
  }

  private BoardEntity makeBoardEntity(boolean defaultYn, int order) {
    BoardEntity boardEntity = new BoardEntity();
    boardEntity.setDelYn(defaultYn);
    boardEntity.setOrder(order);

    return boardRepository.save(boardEntity);
  }
}
