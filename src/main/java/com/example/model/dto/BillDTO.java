package com.example.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class BillDTO {
    private Long billId;
    //    private List<Menu> menuItem;
    private int quantity;
    private LocalDateTime localDateTime;
    private float totalPrice;

    public BillDTO(int quantity, float totalPrice) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public BillDTO() {

    }
}
