package com.example.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class BillDTOVersion2 {
    private Long billId;
    private int quantity;
    private LocalDateTime localDateTime;
    private float totalPrice;
}
