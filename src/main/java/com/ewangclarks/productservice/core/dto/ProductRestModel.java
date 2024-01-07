package com.ewangclarks.productservice.core.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;


@Data
@Builder
public class ProductRestModel {
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @NotNull(message = "price cannot be null")
    private BigDecimal price;
    @NotNull(message = "quantity cannot be null")
    private Integer quantity;
}
