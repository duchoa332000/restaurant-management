package com.example.service;

import com.example.exception.ExceptionsMenuNotFound;
import com.example.model.dto.BillDTO;

import java.util.List;
import java.util.Optional;

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
     * @param id
     * @return
     */
    Optional<BillDTO> findById(Integer id) throws ExceptionsMenuNotFound;

    /**
     * Save bills
     *
     * @param billDTO
     * @return
     */
    BillDTO save(BillDTO billDTO);

    /**
     * Delete by id bills
     *
     * @param id
     */
    void deleteById(Integer id) throws ExceptionsMenuNotFound;

    /**
     * Update bills
     *
     * @param billDTO
     * @return
     */
    BillDTO update(BillDTO billDTO) throws ExceptionsMenuNotFound;

    /**
     * Search bills
     *
     * @param query
     * @return
     */
    List<BillDTO> searchBills(String query);
}
