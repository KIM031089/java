package com.example.demo.board.entity;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.YesNoConverter;

import com.example.demo.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name ="TB_BOARD_TITLE")
public class BoardTitleEntity extends BaseEntity {
  @Id
  @UuidGenerator
  @Column(name = "TITLE_ID")
  private UUID id;
  @Column(name = "LANG_CD")
  private String langCode;
  @Column(name = "TITLE_NAME")
  private String title;

  @Column(name = "DEFAULT_YN")
  @Convert(converter = YesNoConverter.class)
  private boolean defaultYn;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "BOARD_ID")
  private BoardEntity board;
}
