package com.example.demo.board.entity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.YesNoConverter;
import org.springframework.util.CollectionUtils;

import com.example.demo.common.entity.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "TB_BOARD")
@Data
@EqualsAndHashCode(callSuper = true)
public class BoardEntity extends BaseEntity {
  @Id
  @UuidGenerator
  @Column(name = "BOARD_ID")
  private UUID id;

  @Column(name = "DEL_YN")
  @Convert(converter = YesNoConverter.class)
  private boolean delYn;

  @Column(name = "ORD")
  private int order;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "board", fetch = FetchType.LAZY)
  private List<BoardTitleEntity> titles;

  public String getTitle(String langCode) {
    if (CollectionUtils.isEmpty(titles)) {
      return "";
    }
    if (StringUtils.isNotBlank(langCode)) {
      Optional<BoardTitleEntity> titleEntity = titles.stream().filter(e -> langCode.equals(e.getLangCode()))
          .findFirst();
      if (titleEntity.isPresent()) {
        return titleEntity.map(e -> e.getTitle()).get();
      }
    }
    return titles.stream().filter(e -> e.isDefaultYn()).findFirst().map(e -> e.getTitle()).get();
  }
}
