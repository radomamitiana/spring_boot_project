package com.dev.api.service.metier;

import com.dev.api.service.repository.ProductRepository;
import com.dev.api.data.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSMImpl implements ProductSM {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveOrUpdate(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findByIsDeleted(false);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
