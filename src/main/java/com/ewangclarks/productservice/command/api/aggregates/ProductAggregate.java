package com.ewangclarks.productservice.command.api.aggregates;

import com.ewangclarks.productservice.command.api.commands.CreateProductCommand;
import com.ewangclarks.productservice.command.api.events.dto.ProductCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductAggregate {

    @AggregateIdentifier
    private String id;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    @CommandHandler
    public ProductAggregate(CreateProductCommand cmd) {
        ProductCreatedEvent event = new ProductCreatedEvent();
        BeanUtils.copyProperties(cmd, event);
        apply(event);
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.price = event.getPrice();
        this.quantity = event.getQuantity();
    }
}
