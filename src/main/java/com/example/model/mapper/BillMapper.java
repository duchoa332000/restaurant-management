package com.example.model.mapper;

import com.example.model.dto.BillDTO;
import com.example.model.entity.Bill;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BillMapper {
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
