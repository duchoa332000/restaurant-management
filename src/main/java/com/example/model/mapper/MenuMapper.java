package com.example.model.mapper;

import com.example.model.dto.MenuDTO;
import com.example.model.entity.Menu;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MenuMapper {
    public MenuDTO entityToDTO(MenuDTO menu) {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setId(menu.getId());
        menuDTO.setName(menu.getName());
        menuDTO.setDescription(menu.getDescription());
        menuDTO.setImage(menu.getImage());
        menuDTO.setPrice(menu.getPrice());
        menuDTO.setNote(menu.getNote());
        return menuDTO;
    }

    public List<MenuDTO> entityToDTO(List<MenuDTO> menu) {
        return menu.stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    public Menu dtoToEntity(Menu menus) {
        Menu menu = new Menu();
        menu.setId(menus.getId());
        menu.setName(menus.getName());
        menu.setDescription(menus.getDescription());
        menu.setImage(menus.getImage());
        menu.setPrice(menus.getPrice());
        menu.setNote(menus.getNote());
        return menu;
    }

    public List<Menu> dtoToEntity(List<Menu> menuBillDTO) {
        return menuBillDTO.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

}
