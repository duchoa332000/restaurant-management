package com.example.repository;

import com.example.model.dto.MenuDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuDTO, Long> {
    @Query("SELECT m FROM MenuDTO m WHERE " +
            "m.name LIKE CONCAT('%',:query,'%')" +
            "Or m.description LIKE CONCAT('%', :query,'%')")
    List<MenuDTO> searchMenus(String query);

    @Query(value = "SELECT * FROM MenuDTO m WHERE " +
            "m.name LIKE CONCAT('%',:query,'%')" +
            "Or m.description LIKE CONCAT('%', :query,'%')", nativeQuery = true)
    List<MenuDTO> searchMenusSQL(String query);
}
