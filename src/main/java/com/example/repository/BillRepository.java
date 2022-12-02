package com.example.repository;

import com.example.model.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
//    List<Bill> findByBillId(Long billId);

    @Query("SELECT b FROM Bill b WHERE " +
            "b.quantity LIKE CONCAT('%',:query,'%')")
    List<Bill> searchBills(String query);

    @Query(value = "SELECT * FROM Bill b WHERE " +
            "b.quantity LIKE CONCAT('%',:query,'%')", nativeQuery = true)
    List<Bill> searchBillsSQL(String query);
}
