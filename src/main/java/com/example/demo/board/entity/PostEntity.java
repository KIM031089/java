package com.example.demo.board.entity;

import com.example.demo.common.entity.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_POST")
public class PostEntity extends BaseEntity {
  @Id
  private String id;


}
