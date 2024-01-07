package com.ewangclarks.productservice.command.api.controller;

import com.ewangclarks.productservice.command.api.commands.CreateProductCommand;
import com.ewangclarks.productservice.core.dto.ProductRestModel;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductCommandController {

    private final CommandGateway commandGateway;

    @PostMapping("/products")
    public String createProduct(@RequestBody ProductRestModel productRestModel) {
        CreateProductCommand createProductCommand
                = CreateProductCommand.builder()
                .id(UUID.randomUUID().toString())
                .name(productRestModel.getName())
                .price(productRestModel.getPrice())
                .quantity(productRestModel.getQuantity())
                .build();
        return commandGateway.sendAndWait(createProductCommand);
    }
}
