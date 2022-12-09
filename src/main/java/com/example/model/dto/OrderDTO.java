package com.example.model.dto;

import com.example.model.entity.Bill;

import java.util.List;

public class OrderDTO {
    private String orderDescription;
    private List<Bill> cartItems;
    private String customerEmail;
    private String customerName;
}
