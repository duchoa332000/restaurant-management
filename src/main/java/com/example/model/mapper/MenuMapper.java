package com.example.model.mapper;

import com.example.model.dto.MenuDTO;
import com.example.model.dto.MenuDTOVersion2;
import com.example.model.entity.Menu;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MenuMapper {
    /**
     * Entity to DTO in Menu
     *
     * @param menu
     * @return
     */
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

    /**
     * Entity to DTO in Menu version 2
     *
     * @param menu
     * @return
     */
    public MenuDTOVersion2 entityToDTOVersion2(Menu menu) {
        MenuDTOVersion2 menuDTOVersion2 = new MenuDTOVersion2();
        menuDTOVersion2.setMenuId(menu.getMenuId());
        menuDTOVersion2.setName(menu.getName());
        menuDTOVersion2.setPrice(menu.getPrice());
        menuDTOVersion2.setNote(menu.getNote());
        return menuDTOVersion2;
    }

    public List<MenuDTOVersion2> entityToDTOVersion2(List<Menu> menu) {
        return menu.stream().map(this::entityToDTOVersion2).collect(Collectors.toList());
    }

    /**
     * DTO to Entity in Menu
     *
     * @param menuDTO
     * @return
     */
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
