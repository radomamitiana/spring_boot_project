package com.dev.api.service.applicatif;

import com.dev.api.data.dto.ProductDTO;

import java.util.List;

public interface ProductSA {
    ProductDTO create(ProductDTO productDTO);

    ProductDTO update(ProductDTO productDTO);

    List<ProductDTO> getProducts();

    Boolean delete(Long id);
}
