package com.example.controller;

import com.example.exception.ApplicationExceptionsNotFound;
import com.example.model.dto.MenuDTO;
import com.example.model.dto.MenuDTOVersion2;
import com.example.model.entity.Menu;
import com.example.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * This class is to handle Menu Controller
 */
@RestController
@RequestMapping("menumanagement.com")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * Find all menus version 1
     *
     * @return
     */
    @GetMapping("v1/menus")
    public List<MenuDTO> findAll() {
        return menuService.findAll();
    }

    /**
     * Find all menu version 2
     *
     * @return
     */
    @GetMapping("v2/menus")
    public List<MenuDTOVersion2> findAllV2() {
        return menuService.findAllV2();
    }

    /**
     * Find by Menu id
     *
     * @param menuId
     * @return
     */
    @GetMapping("/{menuId}")
    public ResponseEntity<Optional<Menu>> getMenu(@PathVariable("menuId") Long menuId) throws ApplicationExceptionsNotFound {
        Optional<Menu> findById = menuService.findById(menuId);
        return ResponseEntity.ok(findById);
    }

    /**
     * Add a new menu
     *
     * @param
     * @return
     */
    @PostMapping
    public ResponseEntity<Menu> add(@Valid @RequestBody Menu menu) throws ApplicationExceptionsNotFound {
        Menu saveMenus = menuService.save(menu);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveMenus);
    }

    /**
     * Update a menus
     *
     * @param
     * @return
     */
    @PutMapping
    public ResponseEntity<Menu> update(@RequestBody Menu menu) throws ApplicationExceptionsNotFound {
        Menu menus = menuService.update(menu);
        return ResponseEntity.ok(menus);
    }

    /**
     * Delete an existing menu
     *
     * @param
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Menu> delete(@PathVariable("id") Long id) throws ApplicationExceptionsNotFound {
        menuService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Search menus
     *
     * @param query
     * @return
     */
    @GetMapping("/search")
    public ResponseEntity<List<Menu>> searchMenus(@RequestParam("query") String query) {
        return ResponseEntity.ok(menuService.searchMenus(query));
    }

    /**
     * use responseEntity in menu
     *
     * @return
     */
    @GetMapping("/menu")
    public ResponseEntity<List<MenuDTO>> menuDTOS() {
        List<MenuDTO> menuDTOS = new ArrayList<>();
        menuDTOS.add(new MenuDTO("Sting", "Sting Cold", "sting.jpg", 20000, "sting"));
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.accepted().headers(headers).body(menuDTOS);
    }

}