package com.example.service;

import com.example.exception.ApplicationExceptionsNotFound;
import com.example.model.dto.MenuDTO;
import com.example.model.dto.MenuDTOVersion2;
import com.example.model.entity.Menu;

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
     * Find all menus in version 2
     *
     * @return
     */
    List<MenuDTOVersion2> findAllV2();

    /**
     * Find by id menus
     *
     * @param menuId
     * @return
     */
    Optional<Menu> findById(Long menuId) throws ApplicationExceptionsNotFound;


    /**
     * Delete by id menus
     *
     * @param id
     */
    void deleteById(Long id) throws ApplicationExceptionsNotFound;


    /**
     * Save menus
     *
     * @param
     * @return
     */
    Menu save(Menu menu) throws ApplicationExceptionsNotFound;

    /**
     * Update menus
     *
     * @param
     * @return
     */
    Menu update(Menu menu) throws ApplicationExceptionsNotFound;

    /**
     * Search menus
     *
     * @param query
     * @return
     */
    List<Menu> searchMenus(String query);


}
