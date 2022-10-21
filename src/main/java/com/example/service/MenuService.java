package com.example.service;

import com.example.model.dto.MenuDTO;

import java.util.List;
import java.util.Optional;

/**
 * This is a Menu Service
 */
public interface MenuService {
    /**
     * Find all menus
     *
     * @return
     */
    List<MenuDTO> findAll();

    /**
     * Delete by id menus
     *
     * @param id
     */
    void deleteById(Long id);

    /**
     * Find by id menus
     *
     * @param id
     * @return
     */
    Optional<MenuDTO> findById(Long id);

    /**
     * Save menus
     *
     * @param
     * @return
     */
    MenuDTO save(MenuDTO menuDTO);

    /**
     * Update menus
     *
     * @param menuDTO
     * @return
     */
    MenuDTO update(MenuDTO menuDTO);

    /**
     * Search menus
     *
     * @param query
     * @return
     */
    List<MenuDTO> searchMenus(String query);


}
