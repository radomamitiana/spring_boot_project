package com.dev.api.mapper;

import com.dev.api.data.domain.Product;
import com.dev.api.data.dto.ProductDTO;

import java.util.List;

public interface ProductMapper {
    ProductDTO productToProductDTO(Product product);

    Product productDTOToProduct(ProductDTO productDTO);

    List<ProductDTO> productsToProductDTOS(List<Product> products);
}
