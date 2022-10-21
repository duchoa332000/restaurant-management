package com.example.service.impl;

import com.example.model.dto.BillDTO;
import com.example.model.mapper.BillMapper;
import com.example.repository.BillRepository;
import com.example.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private BillMapper billMapper;

    /**
     * Find all findAll
     *
     * @return
     */
    @Override
    public List<BillDTO> findAll() {
        List<BillDTO> billDTOS = billRepository.findAll();
        return billMapper.entityToDTO(billDTOS);
    }

    /**
     * This class is to handle business findById
     *
     * @param id
     * @return
     */
    @Override
    public Optional<BillDTO> findById(Integer id) {
        return billRepository.findById(id);
    }

    /**
     * This class is to handle business Save
     *
     * @param
     * @return
     */
    @Override
    public BillDTO save(BillDTO billDTO) {
        return billRepository.save(billDTO);
    }

    /**
     * This class is to handle business DeleteId
     *
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        billRepository.deleteById(id);
    }

    /**
     * This class is to handle business Update
     *
     * @param
     * @return
     */
    @Override
    public BillDTO update(BillDTO billDTO) {
        BillDTO[] billDTOS = new BillDTO[0];
        for (BillDTO updateBill : billDTOS) {
            if (updateBill.getId() == billDTO.getId()) {
                updateBill.setMenuItems(billDTO.getMenuItems());
                updateBill.setQuantity(billDTO.getQuantity());
                updateBill.setOrderTime(billDTO.getOrderTime());
                updateBill.setOrderDate(billDTO.getOrderDate());

            }
        }
        return billRepository.save(billDTO);
    }

    /**
     * Search  bills infor
     *
     * @param query
     * @return
     */
    @Override
    public List<BillDTO> searchBills(String query) {
        List<BillDTO> billDTOS = billRepository.searchBills(query);
        return billDTOS;
    }

}
