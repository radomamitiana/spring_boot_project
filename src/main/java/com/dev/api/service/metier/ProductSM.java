package com.dev.api.service.metier;

import com.dev.api.data.domain.Product;

import java.util.List;

public interface ProductSM {
    Product saveOrUpdate(Product product);

    List<Product> findAll();

    Product findById(Long id);
}
