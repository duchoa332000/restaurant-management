package com.example.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class Bill {
    @Id
    private int id;
    private String menuItems;
    private int quantity;
    private String orderTime;
    ///localTime
    private String orderDate;

}
