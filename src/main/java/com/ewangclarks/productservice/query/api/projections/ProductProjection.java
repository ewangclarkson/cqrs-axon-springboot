package com.ewangclarks.productservice.query.api.projections;


import com.ewangclarks.productservice.core.model.Product;
import com.ewangclarks.productservice.core.repository.ProductRepository;
import com.ewangclarks.productservice.query.api.queries.GetProductQuery;
import com.ewangclarks.productservice.query.api.queries.GetSingleProductQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.MissingResourceException;

@Component
@RequiredArgsConstructor
public class ProductProjection {

    private final ProductRepository productRepository;

    @QueryHandler
    List<Product> getProducts(GetProductQuery getProductQuery) {
        return productRepository.findAll();
    }

    @QueryHandler
    Product getProductById(GetSingleProductQuery getSingleProductQuery){
        return productRepository.findById(getSingleProductQuery.getId()).orElseThrow(() -> new MissingResourceException("","The resource could not be fould",""));
    }

}
