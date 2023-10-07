package com.example.mferreiradb.products.controllers;

import com.example.mferreiradb.products.entities.Product;
import com.example.mferreiradb.products.dtos.ProductRequestDTO;
import com.example.mferreiradb.products.useCases.CreateProductUseCase;
import com.example.mferreiradb.products.useCases.GetAllProductsUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final CreateProductUseCase _createCreateProductUseCase;
    private final GetAllProductsUseCase _getAllProductsUseCase;
    public ProductController(final CreateProductUseCase createProductUseCase, final GetAllProductsUseCase getAllProductsUseCase) {
        this._createCreateProductUseCase = createProductUseCase;
        this._getAllProductsUseCase = getAllProductsUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductRequestDTO body) {
        this._createCreateProductUseCase.execute(body.name, body.price);
        return ResponseEntity.status(201).build();
    };

    @GetMapping
    public List<Product> getProducts() {
        return this._getAllProductsUseCase.execute();
    }
}
