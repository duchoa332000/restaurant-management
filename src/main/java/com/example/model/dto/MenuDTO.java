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
    
}
