package com.dev.api.service.applicatif;

import com.dev.api.exceptions.FunctionalInvalidDataException;
import com.dev.api.service.metier.ProductSM;
import com.dev.api.data.dto.ProductDTO;
import com.dev.api.data.domain.Product;
import com.dev.api.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class ProductSAImpl implements ProductSA {

    @Autowired
    private ProductSM productSM;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        if (Objects.isNull(productDTO.getCreatedDate())) {
            productDTO.setCreatedDate(LocalDate.now());
        }
        this.verifyData(productDTO, false);
        return productMapper.productToProductDTO(productSM.saveOrUpdate(
                productMapper.productDTOToProduct(productDTO)
        ));
    }


    @Override
    public ProductDTO update(ProductDTO productDTO) {
        if (Objects.isNull(productDTO.getCreatedDate())) {
            productDTO.setCreatedDate(LocalDate.now());
        }
        this.verifyData(productDTO, true);
        return productMapper.productToProductDTO(productSM.saveOrUpdate(
                productMapper.productDTOToProduct(productDTO)
        ));
    }

    @Override
    public List<ProductDTO> getProducts() {
        return productMapper.productsToProductDTOS(productSM.findAll());
    }

    @Override
    public Boolean delete(Long id) {
        Product product = productSM.findById(id);
        if (Objects.isNull(product))
            return false;
        product.setIsDeleted(true);
        productSM.saveOrUpdate(product);
        return true;
    }

    private void verifyData(ProductDTO productDTO, boolean isUpdate) {

        if (isUpdate && Objects.isNull(productDTO.getId()))
            throw new FunctionalInvalidDataException("ID_IS_NULL");
        if (StringUtils.isEmpty(productDTO.getName())
                || Objects.isNull(productDTO.getCreatedDate())
                || Objects.isNull(productDTO.getPrice())) {
            throw new FunctionalInvalidDataException("DATA_HAS_ERROR");
        }
    }
}
