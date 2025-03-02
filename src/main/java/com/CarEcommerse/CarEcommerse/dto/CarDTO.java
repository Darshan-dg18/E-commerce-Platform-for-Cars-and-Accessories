package com.CarEcommerse.CarEcommerse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private String color;
    private BigDecimal price;
    private String description;
    private String imageUrl;
    private Boolean available;
}