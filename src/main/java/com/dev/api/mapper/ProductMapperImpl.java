package com.dev.api.mapper;

import com.dev.api.data.domain.Product;
import com.dev.api.data.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductMapperImpl implements ProductMapper {
    @Override
    public ProductDTO productToProductDTO(Product product) {
        if (Objects.nonNull(product)) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setPrice(product.getPrice());
            productDTO.setCreatedDate(product.getCreatedDate());
            productDTO.setIsDeleted(product.getIsDeleted());
            return productDTO;
        }
        return null;
    }

    @Override
    public Product productDTOToProduct(ProductDTO productDTO) {
        if (Objects.nonNull(productDTO)) {
            Product product = new Product();
            product.setId(productDTO.getId());
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setCreatedDate(productDTO.getCreatedDate());
            product.setIsDeleted(productDTO.getIsDeleted());
            return product;
        }
        return null;
    }

    @Override
    public List<ProductDTO> productsToProductDTOS(List<Product> products) {
        return products
                .stream()
                .map(this::productToProductDTO)
                .collect(Collectors.toList());
    }
}
