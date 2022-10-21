package com.example.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "billmanagement")
public class BillDTO {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "menu_items")
    private String menuItems;
    @Column(name = "quantity")
    private int quantity;
    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "order_time")
    private String orderTime;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @Column(name = "order_date")
    private String orderDate;

    public BillDTO(int id, String menuItems, int quantity, String orderTime, String orderDate) {
        this.id = id;
        this.menuItems = menuItems;
        this.quantity = quantity;
        this.orderTime = orderTime;
        this.orderDate = orderDate;
    }

    public BillDTO() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(String menuItems) {
        this.menuItems = menuItems;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }


}
