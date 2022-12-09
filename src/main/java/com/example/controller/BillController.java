package com.example.controller;

import com.example.exception.ApplicationExceptionsNotFound;
import com.example.model.dto.BillDTO;
import com.example.model.dto.BillDTOVersion2;
import com.example.model.entity.Bill;
import com.example.service.BillService;
import com.example.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is to handle Bill Controller
 */
@RestController
@RequestMapping("billmanagement.com")
public class BillController {
    @Autowired
    private BillService billService;

    @Autowired
    private MenuService menuService;
    

    /**
     * Find all Bill version 1
     *
     * @return
     */
    @GetMapping("v1/bills")
    public List<BillDTO> findAll() {
        return billService.findAll();
    }

    /**
     * Find all Bill version 2
     *
     * @return
     */
    @GetMapping("v2/bills")
    public List<BillDTOVersion2> findAllV2() {
        return billService.findAllV2();
    }


    /**
     * Find by Bill id
     *
     * @param billId
     * @return
     */
    @GetMapping("/{billId}")
    public ResponseEntity<Bill> getBill(@PathVariable Long billId) throws ApplicationExceptionsNotFound {
        Bill findById = billService.findById(billId);
        return ResponseEntity.ok(findById);
    }

    /**
     * Add a new bill
     *
     * @param
     * @return
     */
    @PostMapping
    public ResponseEntity<Bill> add(@Valid @RequestBody Bill bill) throws ApplicationExceptionsNotFound {
        Bill saveBills = billService.save(bill);
//        float total = billServiceImpl.calculatesTotalPrice();
        return ResponseEntity.status(HttpStatus.CREATED).body(saveBills);
    }

    /**
     * Delete an existing bill
     *
     * @param
     * @return
     */
    @DeleteMapping("/{billId}")
    public ResponseEntity<Bill> delete(@PathVariable("billId") Long billId) throws ApplicationExceptionsNotFound {
        billService.deleteById(billId);
        return ResponseEntity.noContent().build();
    }

    /**
     * Update bills
     *
     * @param bill
     * @return
     * @throws ApplicationExceptionsNotFound
     */
    @PutMapping
    public ResponseEntity<Bill> update(@RequestBody Bill bill) throws ApplicationExceptionsNotFound {
        Bill bills = billService.update(bill);
        return ResponseEntity.ok(bills);
    }

    /**
     * Assign menu to bill
     *
     * @param
     * @return
     */

    @PutMapping("/{billId}/menu/{menuId}")
    public Bill assignMenuToBill(
            @PathVariable Long billId,
            @PathVariable Long menuId) {
        return billService.assignMenuToBill(billId, menuId);
    }

    /**
     * Search bills
     *
     * @param query
     * @return
     */
    @GetMapping("/search")
    public List<Bill> searchBills(@RequestParam("query") String query) {
        return billService.searchBills(query);
    }

    /**
     * use responseEntity in bill
     *
     * @return
     */
    @GetMapping("/billdto")
    public ResponseEntity<List<BillDTO>> billDTOS() {
        List<BillDTO> billDTOS = new ArrayList<>();
        billDTOS.add(new BillDTO(2, 35000));
        billDTOS.add(new BillDTO(3, 15000));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Reponsed", "BillController");
        return ResponseEntity.accepted().headers(headers).body(billDTOS);

    }
}
