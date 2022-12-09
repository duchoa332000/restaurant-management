package com.example.model.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CustomerDTO {
    private Long customerId;
    private String name;
    private String email;

    public CustomerDTO() {

    }
}
