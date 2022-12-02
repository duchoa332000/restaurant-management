package com.example.repository;

import com.example.model.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
//    List<Menu> findByName(String name);

    @Query("SELECT m FROM Menu m WHERE " +
            "m.name LIKE CONCAT('%',:query,'%')" +
            "Or m.description LIKE CONCAT('%', :query,'%')")
    List<Menu> searchMenus(String query);

    @Query(value = "SELECT * FROM menus m WHERE " +
            "m.name LIKE CONCAT('%',:query,'%')" +
            "Or m.description LIKE CONCAT('%', :query,'%')", nativeQuery = true)
    List<Menu> searchMenusSQL(String query);
}
