package com.example.service;

import com.example.exception.ApplicationExceptionsNotFound;
import com.example.model.dto.BillDTO;
import com.example.model.entity.Bill;

import java.util.List;

public interface BillService {
    /**
     * Find all bills
     *
     * @return
     */
    List<BillDTO> findAll();

    /**
     * Find by id bills
     *
     * @param billId
     * @return
     */
    Bill findById(Long billId) throws ApplicationExceptionsNotFound;

    /**
     * Save bills
     *
     * @param
     * @return
     */
    Bill save(Bill bill) throws ApplicationExceptionsNotFound;

    /**
     * Delete by id bills
     *
     * @param billId
     */
    void deleteById(Long billId) throws ApplicationExceptionsNotFound;

    Bill update(Bill bill) throws ApplicationExceptionsNotFound;

    /**
     * Update bills
     *
     * @param
     * @return
     */
    Bill assignMenuToBill(Long billId, Long menuId);

//    List<Bill> findByBillId(Long billId);

    /**
     * Search bills
     *
     * @param query
     * @return
     */
    List<Bill> searchBills(String query);
}
