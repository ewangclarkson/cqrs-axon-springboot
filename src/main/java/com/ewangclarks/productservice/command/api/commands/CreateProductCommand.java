package com.ewangclarks.productservice.command.api.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductCommand {
    @TargetAggregateIdentifier
    private String id;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
