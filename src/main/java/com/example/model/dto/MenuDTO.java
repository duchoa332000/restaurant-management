package com.example.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuDTO {
    private Long menuId;
    private String name;
    private String description;
    private String image;
    private int price;
    private String note;


//    public MenuDTO() {
//    }


}
