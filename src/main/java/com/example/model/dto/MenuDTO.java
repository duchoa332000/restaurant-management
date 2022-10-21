package com.example.model.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "menumanagement")
public class MenuDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "image")
    private String image;
    @Column(name = "price")
    private int price;
    @Column(name = "note")
    private String note;

    public MenuDTO(String name, String description, String image, int price, String note) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.note = note;
    }

    public MenuDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
