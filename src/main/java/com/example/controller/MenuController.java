package com.example.controller;

import com.example.model.dto.MenuDTO;
import com.example.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
@RequestMapping("api/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * Find all menus
     *
     * @return
     */
    @GetMapping("/findAll")
    public List<MenuDTO> findAll() {
        return menuService.findAll();
    }

    /**
     * Find by Menu id
     *
     * @param id
     * @return
     */
    @GetMapping("/find/{id}")
    public Optional<MenuDTO> findById(@PathVariable("id") Long id) {
        return menuService.findById(id);
    }

    /**
     * Add a new menu
     *
     * @param
     * @return
     */
    @PostMapping("/addmenu")
    public MenuDTO add(@Valid @RequestBody MenuDTO menuDTO) {
        return menuService.save(menuDTO);
    }

    /**
     * Update a menus
     *
     * @param
     * @return
     */
    @PutMapping("/update/{id}")
    public MenuDTO update(@RequestBody MenuDTO menuDTO) {
        MenuDTO menuDTOS = menuService.update(menuDTO);
        return menuDTOS;
    }

    /**
     * Delete an existing menu
     *
     * @param
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        menuService.deleteById(id);
        return "Menu deleted successfully!";
    }

    /**
     * Search menus
     *
     * @param query
     * @return
     */
    @GetMapping("/search")
    public List<MenuDTO> searchMenus(@RequestParam("query") String query) {
        return menuService.searchMenus(query);
    }

    /**
     * use responseEntity in menu
     *
     * @return
     */
    @GetMapping("/menus")
    public ResponseEntity<List<MenuDTO>> menuDTOS() {
        List<MenuDTO> menuDTOS = new ArrayList<>();
        menuDTOS.add(new MenuDTO("Sting", "Sting Cold", "sting.jpg", 20000, "sting"));
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.accepted().headers(headers).body(menuDTOS);
    }

}
