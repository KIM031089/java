package com.example.demo.common.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;

public abstract class BaseEntity {
  @Column(name = "CREATE_DT")
  private Timestamp createDt;
  @Column(name = "UPDATE_DT")
  private Timestamp updateDt;
}
