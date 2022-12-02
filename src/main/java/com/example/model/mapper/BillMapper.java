package com.example.model.mapper;

import com.example.model.dto.BillDTO;
import com.example.model.dto.BillDTOVersion2;
import com.example.model.entity.Bill;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BillMapper {
    /**
     * Entity to DTO in Bill
     *
     * @param bill
     * @return
     */
    public BillDTO entityToDTO(Bill bill) {
        BillDTO billDTO = new BillDTO();
        billDTO.setBillId(bill.getBillId());
        billDTO.setQuantity(bill.getQuantity());
        billDTO.setLocalDateTime(bill.getLocalDateTime());
        billDTO.setTotalPrice(bill.getTotalPrice());
        return billDTO;
    }

    public List<BillDTO> entityToDTO(List<Bill> bill) {
        return bill.stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    /**
     * Entity to DTO version 2
     *
     * @param bill
     * @return
     */
    public BillDTOVersion2 entityToDTOVersion2(Bill bill) {
        BillDTOVersion2 billDTOVersion2 = new BillDTOVersion2();
        billDTOVersion2.setBillId(bill.getBillId());
        billDTOVersion2.setQuantity(bill.getQuantity());
        billDTOVersion2.setLocalDateTime(bill.getLocalDateTime());
        billDTOVersion2.setTotalPrice(bill.getTotalPrice());
        return billDTOVersion2;
    }

    public List<BillDTOVersion2> entityToDTOVersion2(List<Bill> bill) {
        return bill.stream().map(this::entityToDTOVersion2).collect(Collectors.toList());
    }

    /**
     * DTO to Entity in Bill
     *
     * @param billDTO
     * @return
     */
    public Bill dtoToEntity(BillDTO billDTO) {
        Bill bill = new Bill();
        bill.setBillId(billDTO.getBillId());
        bill.setQuantity(billDTO.getQuantity());
        bill.setLocalDateTime(billDTO.getLocalDateTime());
        bill.setTotalPrice(bill.getTotalPrice());
        return bill;
    }

    public List<Bill> dtoToEntity(List<BillDTO> billDTO) {
        return billDTO.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }


}
