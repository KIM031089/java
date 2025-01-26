package com.example.demo.aSvc.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_MENU")
@Data
@NoArgsConstructor
public class MenuEntity {

  @Id
  @Column(name = "menu_id")
  private String id;

  @Column(name = "menu_order")
  private int order;

  @Column(name = "i18n_id")
  private String i18n;

  // public MenuEntity(int order, String i18n) {
  //   this.id = UUID.randomUUID().toString();
  //   this.order = order;
  //   this.i18n = i18n;
  // }
}
