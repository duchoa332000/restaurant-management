package com.example.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MenuDTOVersion2 {
    private Long menuId;
    private String name;
    //    private String description;
//    private String image;
    private int price;
    private String note;

}
