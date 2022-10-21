package com.example.model.mapper;

import com.example.model.dto.BillDTO;
import com.example.model.entity.Bill;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BillMapper {
    public BillDTO entityToDTO(BillDTO bill) {
        BillDTO billDTO = new BillDTO();
        billDTO.setId(bill.getId());
        billDTO.setMenuItems(bill.getMenuItems());
        billDTO.setQuantity(bill.getQuantity());
        billDTO.setOrderTime(bill.getOrderTime());
        billDTO.setOrderDate(bill.getOrderDate());

        return billDTO;
    }

    public List<BillDTO> entityToDTO(List<BillDTO> bill) {
        return bill.stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    public Bill dtoToEntity(BillDTO billDTO) {
        Bill bill = new Bill();
        bill.setId(billDTO.getId());
        bill.setMenuItems(billDTO.getMenuItems());
        bill.setQuantity(billDTO.getQuantity());
        bill.setOrderTime(billDTO.getOrderTime());
        bill.setOrderDate(String.valueOf(billDTO.getOrderDate()));
        return bill;
    }

    public List<Bill> dtoToEntity(List<BillDTO> billDTO) {
        return billDTO.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }


}
