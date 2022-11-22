package com.example.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "billmanagement")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long billId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "bill_menuitem",
            joinColumns = @JoinColumn(name = "bill_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id"))
    private Set<Menu> menuItem = new HashSet<>();

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total_price")
    private float totalPrice;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "local_datetime")
    private LocalDateTime localDateTime = LocalDateTime.now();

//    public Bill(Long billId, Set<Menu> menuItem, int quantity, float totalPrice, LocalDateTime localDateTime) {
//        this.billId = billId;
//        this.menuItem = menuItem;
//        this.quantity = quantity;
//        this.totalPrice = totalPrice;
//        this.localDateTime = localDateTime;
//    }
//
//    public Long getBillId() {
//        return billId;
//    }
//
//    public void setBillId(Long billId) {
//        this.billId = billId;
//    }
//
//    public Set<Menu> getMenuItem() {
//        return menuItem;
//    }
//
//    public void setMenuItem(Set<Menu> menuItem) {
//        this.menuItem = menuItem;
//    }
//
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


}
