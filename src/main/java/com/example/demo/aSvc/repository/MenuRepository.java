package com.example.demo.aSvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.aSvc.entity.MenuEntity;


@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, String>{

}
