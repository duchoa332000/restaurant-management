package com.example.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillDTO {
    private Long billId;
    private int quantity;
    private LocalDateTime localDateTime;
    private float totalPrice;

//    public BillDTO(Long billId, int quantity, LocalDateTime localDateTime, float totalPrice) {
//        this.billId = billId;
//        this.quantity = quantity;
//        this.localDateTime = localDateTime;
//        this.totalPrice = totalPrice;
//    }
//
//    public BillDTO() {
//
//    }

//    public Long getBillId() {
//        return billId;
//    }
//
//    public void setBillId(Long billId) {
//        this.billId = billId;
//    }

//    public String getMenuItems() {
//        return menuItems;
//    }
//
//    public void setMenuItems(String menuItems) {
//        this.menuItems = menuItems;
//    }

//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public LocalDateTime getLocalDateTime() {
//        return localDateTime;
//    }
//
//    public void setLocalDateTime(LocalDateTime localDateTime) {
//        this.localDateTime = localDateTime;
//    }
//
//    public float getTotalPrice() {
//        return totalPrice;
//    }
//
//    public void setTotalPrice(float totalPrice) {
//        this.totalPrice = totalPrice;
//    }
}
