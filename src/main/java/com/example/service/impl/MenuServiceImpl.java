package com.example.service.impl;


import com.example.exception.ExceptionsMenuNotFound;
import com.example.model.dto.MenuDTO;
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
     * Find all findAll
     *
     * @return
     */
    @Override
    public List<MenuDTO> findAll() {
        List<MenuDTO> menuDTOS = menuRepository.findAll();
        return menuMapper.entityToDTO(menuDTOS);
    }

    /**
     * This class is to handle business Save
     *
     * @param
     * @return
     */
    @Override
    public MenuDTO save(MenuDTO menuDTO) throws ExceptionsMenuNotFound {
        MenuDTO saveMenu = menuRepository.save(menuDTO);
        return saveMenu;

    }

    /**
     * This class is to handle business DeleteId
     *
     * @param id
     */
    @Override
    public void deleteById(Long id) throws ExceptionsMenuNotFound {
        Optional<MenuDTO> findById = menuRepository.findById(id);
        MenuDTO menuDTO = findById
                .orElseThrow(() -> new ExceptionsMenuNotFound(String.format("Menu not found with id %s", id)));
        menuRepository.delete(menuDTO);
    }

    /**
     * This class is to handle business findById
     *
     * @param id
     * @return
     */
    public Optional<MenuDTO> findById(Long id) throws ExceptionsMenuNotFound {
        Optional<MenuDTO> findById = menuRepository.findById(id);
        if (!findById.isPresent()) {
            throw new ExceptionsMenuNotFound(String.format("Menu not found with id %s", id));
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
    public MenuDTO update(MenuDTO menuDTO) throws ExceptionsMenuNotFound {
        Optional<MenuDTO> findById = menuRepository.findById(menuDTO.getId());
        if (!findById.isPresent()) {
            throw new ExceptionsMenuNotFound(String.format("Menu not found with id %s", menuDTO.getId()));
        }
        MenuDTO menuDTOS = findById.get();
        BeanUtils.copyProperties(menuDTO, menuDTOS);
        MenuDTO[] menus = new MenuDTO[0];
        for (MenuDTO updateMenu : menus) {
            if (updateMenu.getId() == menuDTO.getId()) {
                updateMenu.setName(menuDTO.getName());
                updateMenu.setDescription(menuDTO.getDescription());
                updateMenu.setImage(menuDTO.getImage());
                updateMenu.setPrice(menuDTO.getPrice());
                updateMenu.setNote(menuDTO.getNote());
            }
        }
        return menuRepository.save(menuDTO);
    }

    /**
     * Search menus infor
     *
     * @param query
     * @return
     */
    @Override
    public List<MenuDTO> searchMenus(String query) {
        List<MenuDTO> menuDTOS = menuRepository.searchMenus(query);
        return menuDTOS;
    }


}
