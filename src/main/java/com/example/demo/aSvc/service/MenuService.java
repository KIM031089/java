package com.example.demo.aSvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.aSvc.entity.MenuEntity;
import com.example.demo.aSvc.repository.MenuRepository;
import com.example.demo.aSvc.vo.MenuVo;
import com.example.demo.aSvc.vo.MenuVo.Create;

import jakarta.transaction.Transactional;

@Service
public class MenuService {

  @Autowired
  private MenuRepository menuRepo;

  public List<MenuEntity> getMenus() {
    return menuRepo.findAll();
  }

  public List<MenuVo.ListResponse> getMenu2() {
    List<MenuEntity> list = menuRepo.findAll();
    List<MenuVo.ListResponse> resultList = new ArrayList<>();

    // === 
    list.forEach(e -> {
      MenuVo.ListResponse co = MenuVo.ListResponse.builder()
          .id(e.getId())
          .order(e.getOrder())
          .build();
      resultList.add(co);
    });

    // == 자동화...?
    return resultList;
  }

  @Transactional
  public MenuVo.DetailResponse createMenu(Create menu) {
    // MenuEntity menuEntity = MenuEntity.builder()
    // .id(UUID.randomUUID().toString())
    // .order(menu.getOrder())
    // .i18n("1") // FIXME: 수정필요.
    // .build();
    MenuEntity menuEntity = new MenuEntity();
    menuEntity.setI18n("1");
    menuEntity.setId(UUID.randomUUID().toString());
    menuEntity.setOrder(menu.getOrder());

    menuRepo.save(menuEntity);

    return null;
    // return MenuVo.DetailResponse.builder()
    // .id(menuEntity.getId())
    // .order(menuEntity.getOrder())
    // .i18n(menuEntity.getI18n())
    // .build();
  }
}
