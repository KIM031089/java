package com.example.demo.board.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.board.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, UUID> {
  @SuppressWarnings("null")
  @Query("select b from BoardEntity b left join fetch b.titles")
  List<BoardEntity> findAll();
}
