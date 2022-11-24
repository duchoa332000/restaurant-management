package com.example.model.mapper;

import com.example.model.dto.MenuDTO;
import com.example.model.entity.Menu;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MenuMapper {
    public MenuDTO entityToDTO(Menu menu) {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setMenuId(menu.getMenuId());
        menuDTO.setName(menu.getName());
        menuDTO.setDescription(menu.getDescription());
        menuDTO.setImage(menu.getImage());
        menuDTO.setPrice(menu.getPrice());
        menuDTO.setNote(menu.getNote());
        return menuDTO;
    }

    public List<MenuDTO> entityToDTO(List<Menu> menu) {
        return menu.stream().map(this::entityToDTO).collect(Collectors.toList());
    }


//    public List<MenuDTO> entityToDTO(List<Menu> menu) {
//        return menu.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
//    }

    public Menu dtoToEntity(MenuDTO menuDTO) {
        Menu menu = new Menu();
        menu.setMenuId(menuDTO.getMenuId());
        menu.setName(menuDTO.getName());
        menu.setDescription(menuDTO.getDescription());
        menu.setImage(menuDTO.getImage());
        menu.setPrice(menuDTO.getPrice());
        menu.setNote(menuDTO.getNote());
        return menu;
    }

    public List<Menu> dtoToEntity(List<MenuDTO> MenuDTO) {
        return MenuDTO.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

}
