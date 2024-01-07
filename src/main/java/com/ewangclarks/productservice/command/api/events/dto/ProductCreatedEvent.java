package com.ewangclarks.productservice.command.api.events.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreatedEvent {
    private String id;
    private String name;
    private BigDecimal price;
    private Integer quantity;

}
