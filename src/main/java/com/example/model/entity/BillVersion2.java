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
//@Table(name = "billmanagement")
public class BillVersion2 {
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


}
