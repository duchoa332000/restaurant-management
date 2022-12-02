package com.example.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MenuDTO {
    private Long menuId;
    private String name;
    private String description;
    private String image;
    private int price;
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
}
