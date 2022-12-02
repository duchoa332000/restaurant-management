package com.example.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
//@Table(name = "menumanagement")
public class MenuVersion2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long menuId;
    @Column(name = "name")
    @NotBlank(message = "Menu name cannot be blank")
    private String name;
    //    @Column(name = "description")
//    @NotBlank(message = "description shouldn't be null")
//    private String description;
//    @Column(name = "image")
//    @NotBlank(message = "insert an image")
//    private String image;
    @Column(name = "price")
    @NotBlank(message = "price shouldn't be null")
    private int price;
    @Column(name = "note")
    @NotBlank(message = "note shouldn't be null")
    private String note;

    @JsonIgnore
    @ManyToMany(mappedBy = "menuItem", cascade = CascadeType.ALL)
    private Set<Bill> billSet = new HashSet<>();

}
