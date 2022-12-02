package com.example.service.impl;


import com.example.exception.ApplicationExceptionsNotFound;
import com.example.model.dto.MenuDTO;
import com.example.model.dto.MenuDTOVersion2;
import com.example.model.entity.Menu;
import com.example.model.mapper.MenuMapper;
import com.example.repository.MenuRepository;
import com.example.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This class is to handle business logic for Menu
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private MenuMapper menuMapper;

    /**
     * Find all Menus
     *
     * @return
     */
    @Override
    public List<MenuDTO> findAll() {
        List<Menu> menu = menuRepository.findAll();
        return menuMapper.entityToDTO(menu);
    }

    /**
     * Find All Menu Version 2
     *
     * @return
     */
    @Override
    public List<MenuDTOVersion2> findAllV2() {
        List<Menu> menuVersion2 = menuRepository.findAll();
        return menuMapper.entityToDTOVersion2(menuVersion2);
    }

    /**
     * This class is to handle business Save
     *
     * @param
     * @return
     */
    @Override
    public Menu save(Menu menu) throws ApplicationExceptionsNotFound {
        Menu saveMenu = menuRepository.save(menu);
        return saveMenu;

    }

    /**
     * This class is to handle business DeleteId
     *
     * @param menuId
     */
    @Override
    public void deleteById(Long menuId) throws ApplicationExceptionsNotFound {
        Optional<Menu> findById = menuRepository.findById(menuId);
        Menu menu = findById.orElseThrow(() ->
                new ApplicationExceptionsNotFound(String.format("Menu not found with id %s", menuId)));
        menuRepository.delete(menu);
    }

    /**
     * This class is to handle business findById
     *
     * @param menuId
     * @return
     */
    public Optional<Menu> findById(Long menuId) throws ApplicationExceptionsNotFound {
        Optional<Menu> findById = menuRepository.findById(menuId);
        if (!findById.isPresent()) {
            throw new ApplicationExceptionsNotFound(String.format("Menu not found with id %s", menuId));
        }
        return Optional.of(findById.get());

    }

    /**
     * This class is to handle business Update
     *
     * @param
     * @return
     */
    @Override
    public Menu update(Menu menu) throws ApplicationExceptionsNotFound {
        Optional<Menu> findById = menuRepository.findById(menu.getMenuId());
        if (!findById.isPresent()) {
            throw new ApplicationExceptionsNotFound(String.format("Menu not found with id %s", menu.getMenuId()));
        }
        Menu menus = findById.get();
        BeanUtils.copyProperties(menu, menu);
        MenuDTO[] menuDTOS = new MenuDTO[0];
        for (MenuDTO updateMenu : menuDTOS) {
            if (updateMenu.getMenuId() == menu.getMenuId()) {
                updateMenu.setName(menu.getName());
                updateMenu.setDescription(menu.getDescription());
                updateMenu.setImage(menu.getImage());
                updateMenu.setPrice(menu.getPrice());
                updateMenu.setNote(menu.getNote());
            }
        }
        return menuRepository.save(menu);
    }

    /**
     * Search menus infor
     *
     * @param query
     * @return
     */
    @Override
    public List<Menu> searchMenus(String query) {
        List<Menu> menus = menuRepository.searchMenus(query);
        return menus;
    }


}
