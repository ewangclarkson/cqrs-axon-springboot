package com.ewangclarks.productservice.core.repository;

import com.ewangclarks.productservice.core.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {

}
