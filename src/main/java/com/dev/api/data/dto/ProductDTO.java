package com.dev.api.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String name;
    private LocalDate createdDate;
    private Double price;
}
