//package com.example.model.entity;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Getter
//@Setter
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int orderId;
//
//    private String orderDescription;
//
//    @OneToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "customer_id", referencedColumnName = "id")
//    private Customer customer;
//
//
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "bill_menuitem",
//            joinColumns = @JoinColumn(name = "bill_id"),
//            inverseJoinColumns = @JoinColumn(name = "menu_id"))
//    private Set<Menu> menuItem = new HashSet<>();
//}
