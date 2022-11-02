package com.example.controller;

import com.example.exception.ExceptionsMenuNotFound;
import com.example.model.dto.MenuDTO;
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
    public ResponseEntity<Optional<MenuDTO>> getMenu(@PathVariable("id") Long id) throws ExceptionsMenuNotFound {
        Optional<MenuDTO> findById = menuService.findById(id);
        return ResponseEntity.ok(findById);
    }

    /**
     * Add a new menu
     *
     * @param
     * @return
     */
    @PostMapping("/addmenu")
    public ResponseEntity<MenuDTO> add(@Valid @RequestBody MenuDTO menuDTO) throws ExceptionsMenuNotFound {
        MenuDTO saveMenus = menuService.save(menuDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveMenus);
    }

    /**
     * Update a menus
     *
     * @param
     * @return
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<MenuDTO> update(@RequestBody MenuDTO menuDTO) throws ExceptionsMenuNotFound {
        MenuDTO menuDTOS = menuService.update(menuDTO);
        return ResponseEntity.ok(menuDTOS);
    }

    /**
     * Delete an existing menu
     *
     * @param
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MenuDTO> delete(@PathVariable("id") Long id) throws ExceptionsMenuNotFound {
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
