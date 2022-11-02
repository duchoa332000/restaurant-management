package com.example.controller;

import com.example.exception.ExceptionsMenuNotFound;
import com.example.model.dto.BillDTO;
import com.example.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This class is to handle Bill Controller
 */
@RestController
@RequestMapping("bills")
public class BillController {
    @Autowired
    private BillService billService;

    @GetMapping("/findAll")
    public List<BillDTO> findAll() {
        return billService.findAll();
    }

    /**
     * Find by Bill id
     *
     * @param id
     * @return
     */
    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<BillDTO>> getBill(@PathVariable("id") Integer id) throws ExceptionsMenuNotFound {
        Optional<BillDTO> findById = billService.findById(id);
        return ResponseEntity.ok(findById);
    }


    /**
     * Add a new bill
     *
     * @param
     * @return
     */
    @PostMapping("/addbill")
    public BillDTO add(@Valid @RequestBody BillDTO billDTO) {
        return billService.save(billDTO);
    }

    /**
     * Delete an existing bill
     *
     * @param
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BillDTO> delete(@PathVariable("id") Integer id) throws ExceptionsMenuNotFound {
        billService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Update a bills
     *
     * @param
     * @return
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<BillDTO> update(@RequestBody BillDTO billDTO) throws ExceptionsMenuNotFound {
        BillDTO billDTOS = billService.update(billDTO);
        return ResponseEntity.ok(billDTOS);
    }


    /**
     * Search bills
     *
     * @param query
     * @return
     */
    @GetMapping("/search")
    public List<BillDTO> searchBills(@RequestParam("query") String query) {
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
        billDTOS.add(new BillDTO(1, "Sting", 2, "1:38:23", "20-10-2022"));
        billDTOS.add(new BillDTO(2, "7 Up", 1, "1:38:25", "20-10-2022"));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Reponsed", "BillController");
        return ResponseEntity.accepted().headers(headers).body(billDTOS);

    }
}
