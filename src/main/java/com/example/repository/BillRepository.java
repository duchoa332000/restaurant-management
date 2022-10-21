package com.example.repository;

import com.example.model.dto.BillDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<BillDTO, Integer> {
    @Query("SELECT b FROM BillDTO b WHERE " +
            "b.menuItems LIKE CONCAT('%',:query,'%')")
    List<BillDTO> searchBills(String query);

    @Query(value = "SELECT * FROM BillDTO b WHERE " +
            "b.menuItems LIKE CONCAT('%',:query,'%')", nativeQuery = true)
    List<BillDTO> searchBillsSQL(String query);
}
