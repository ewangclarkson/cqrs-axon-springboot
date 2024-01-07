package com.ewangclarks.productservice.query.api.controllers;

import com.ewangclarks.productservice.core.model.Product;
import com.ewangclarks.productservice.query.api.queries.GetProductQuery;
import com.ewangclarks.productservice.query.api.queries.GetSingleProductQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductQueryController {

    private final QueryGateway queryGateway;

    @GetMapping("/products")
    ResponseEntity<List<Product>> getProducts() throws ExecutionException, InterruptedException {
        GetProductQuery getProductQuery = new GetProductQuery();

       List<Product> products= queryGateway.query(getProductQuery, ResponseTypes.multipleInstancesOf(Product.class)).get();
       return ResponseEntity.ok(products);

    }

    @GetMapping("/products/{id}")
    ResponseEntity<Product> getProduct(@PathVariable String id) throws ExecutionException, InterruptedException {
        GetSingleProductQuery getSingleProductQuery = new GetSingleProductQuery();
        getSingleProductQuery.setId(id);
        Product product= queryGateway.query(getSingleProductQuery, ResponseTypes.instanceOf(Product.class)).get();
        return ResponseEntity.ok(product);

    }
}
