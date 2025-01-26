package com.example.demo.aSvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.aSvc.entity.MenuEntity;
import com.example.demo.aSvc.service.MenuService;
import com.example.demo.aSvc.vo.MenuVo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/comm/")
@RestController
public class MenuController {

  @Autowired
  private MenuService menuService;

  @GetMapping("/menus")
  public List<MenuEntity> getMenus() {
    return menuService.getMenus();
  }

  @PostMapping("/menu")
  public MenuVo.DetailResponse createMenu(@RequestBody MenuVo.Create menu) {
    return menuService.createMenu(menu);
  }

  @GetMapping("errorTest")
  public String errorTest() throws Exception {
    if( 1==1){

      throw new Exception("test");
    }
    return "su?";
  }

}
