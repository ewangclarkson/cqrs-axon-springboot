package com.ewangclarks.productservice.command.api.events;

import com.ewangclarks.productservice.command.api.events.dto.ProductCreatedEvent;
import com.ewangclarks.productservice.core.model.Product;
import com.ewangclarks.productservice.core.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductEventsHandler {

    private final ProductRepository productRepository;

    @EventHandler
    public void on(ProductCreatedEvent event) {
        Product saveProduct = new Product();
        BeanUtils.copyProperties(event, saveProduct);
        productRepository.save(saveProduct);
    }
}
