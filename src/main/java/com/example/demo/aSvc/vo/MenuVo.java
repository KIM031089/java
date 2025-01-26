package com.example.demo.aSvc.vo;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

public class MenuVo {

  @Data
  public static class Create {
    private int order;
    private int a;
    private String b;
    private Date c;
  }

  @Data
  @Builder
  public static class DetailResponse{
    private String id;
    private int order;  
    private String i18n;
  }

  @Data
  @Builder
  public static class ListResponse {
    private String id;
    private int order;  
  }
}