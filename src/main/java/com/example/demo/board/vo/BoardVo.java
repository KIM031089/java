package com.example.demo.board.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;

public class BoardVo {

  @Data
  @Builder
  public static class ListResponse {
    private String id;
    private boolean delYn;
    private int order;
    private String title;
  }

  @Data
  @Builder
  public static class DetailResponse {
    private String id;
    private boolean delYn;
    private int order;
    private List<BoardTitle> titles;
  }

  @Data
  @Builder
  public static class ListRequest {
    private String langCode;
  }

  @Data
  public static class CreateRequest {
    @NotNull
    @PositiveOrZero
    private int order;

    @Valid
    @NotNull
    private List<BoardTitle> titles;
  }

  @Data
  public static class UpdateRequest {
    private String id;

    @NotNull
    @PositiveOrZero
    private int order;

    @Valid
    @NotNull
    private List<BoardTitle> titles;
  }

  @Data
  @Builder
  public static class BoardTitle {
    private String id;

    @NotBlank
    private String langCode;

    @NotBlank
    private String title;

    @NotNull
    @JsonAlias({ "isDefaultYn" })
    private boolean defaultYn;
  }
}
