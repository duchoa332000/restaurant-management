package com.example.service;

import com.example.exception.ApplicationExceptionsNotFound;
import com.example.model.dto.BillDTO;
import com.example.model.dto.BillDTOVersion2;
import com.example.model.entity.Bill;

import java.util.List;

public interface BillService {
    /**
     * Find all bills
     *
     * @return
     */
    List<BillDTO> findAll();

    List<BillDTOVersion2> findAllV2();

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

    /**
     * Update bills
     *
     * @param bill
     * @return
     * @throws ApplicationExceptionsNotFound
     */
    Bill update(Bill bill) throws ApplicationExceptionsNotFound;

    /**
     * Assign Menu to Bill
     *
     * @param
     * @return
     */
    Bill assignMenuToBill(Long billId, Long menuId);
    
    /**
     * Search bills
     *
     * @param query
     * @return
     */
    List<Bill> searchBills(String query);

}
