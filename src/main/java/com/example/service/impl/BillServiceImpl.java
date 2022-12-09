package com.example.service.impl;

import com.example.exception.ApplicationExceptionsNotFound;
import com.example.model.dto.BillDTO;
import com.example.model.dto.BillDTOVersion2;
import com.example.model.entity.Bill;
import com.example.model.entity.Menu;
import com.example.model.mapper.BillMapper;
import com.example.repository.BillRepository;
import com.example.repository.MenuRepository;
import com.example.service.BillService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private BillMapper billMapper;


    /**
     * Find all findAll
     *
     * @return
     */
    @Override
    public List<BillDTO> findAll() {
        List<Bill> bill = billRepository.findAll();
        return billMapper.entityToDTO(bill);
    }

    @Override
    public List<BillDTOVersion2> findAllV2() {
        List<Bill> billVersion2 = billRepository.findAll();
        return billMapper.entityToDTOVersion2(billVersion2);
    }

    /**
     * This class is to handle business findById
     *
     * @param billId
     * @return
     */
    @Override
    public Bill findById(Long billId) throws ApplicationExceptionsNotFound {
        Optional<Bill> findById = billRepository.findById(billId);
        if (!findById.isPresent()) {
            throw new ApplicationExceptionsNotFound(String.format("Bill not found with id %s", billId));
        }
        return findById.get();
    }

    /**
     * This class is to handle business Save
     *
     * @param
     * @return
     */
    @Override
    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }

    /**
     * This class is to handle business DeleteId
     *
     * @param billId
     */
    @Override

    public void deleteById(Long billId) throws ApplicationExceptionsNotFound {
        Optional<Bill> findById = billRepository.findById(billId);
        Bill bill = findById
                .orElseThrow(() -> new ApplicationExceptionsNotFound(String.format("Bill not found with id %s", billId)));
        billRepository.delete(bill);

    }

    /**
     * This class is to handle business Update
     *
     * @param
     * @return
     */
    @Override
    public Bill update(Bill bill) throws ApplicationExceptionsNotFound {
        Optional<Bill> findById = billRepository.findById(bill.getBillId());
        if (!findById.isPresent()) {
            throw new ApplicationExceptionsNotFound(String.format("Menu not found with id %s", bill.getBillId()));
        }
        BeanUtils.copyProperties(bill, bill);
        Bill[] bills = new Bill[0];
        for (Bill updateBill : bills) {
            if (updateBill.getBillId() == bill.getBillId()) {
                updateBill.setQuantity(bill.getQuantity());
                updateBill.setTotalPrice(bill.getTotalPrice());

            }

        }
        return billRepository.save(bill);
    }

    /**
     * Assign Menu to Bill
     *
     * @param billId
     * @param menuId
     * @return
     */
    public Bill assignMenuToBill(Long billId, Long menuId) {
        Set<Menu> menuSet = null;
        Bill bill = billRepository.findById(billId).get();
        Menu menu = menuRepository.findById(menuId).get();
        menuSet = bill.getMenuItem();
        menuSet.add(menu);
        bill.setMenuItem(menuSet);
        return billRepository.save(bill);
    }

    /**
     * Search  bills infor
     *
     * @param query
     * @return
     */
    @Override
    public List<Bill> searchBills(String query) {
        List<Bill> bills = billRepository.searchBills(query);
        return bills;
    }


}
