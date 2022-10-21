package com.example.model.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String description;
    private String image;
    private int price;
    private String note;


}
