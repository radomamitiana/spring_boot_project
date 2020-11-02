package com.dev.api.handler;

import com.dev.api.data.dto.ProductDTO;
import com.dev.api.service.applicatif.ProductSA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductSA productSA;

    @PostMapping("")
    public ResponseEntity<ProductDTO> handlerCreateProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productSA.create(productDTO));
    }

    @PutMapping("")
    public ResponseEntity<ProductDTO> handlerUpdateProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(productSA.update(productDTO));
    }

    @GetMapping("")
    public ResponseEntity<List<ProductDTO>> handlerGetAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productSA.getProducts());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> handlerSearchProducts(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productSA.delete(id));
    }
}
