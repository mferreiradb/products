package com.example.mferreiradb.products.controllers;

import com.example.mferreiradb.products.entities.Product;
import com.example.mferreiradb.products.dtos.ProductRequestDTO;
import com.example.mferreiradb.products.useCases.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final CreateProductUseCase _createCreateProductUseCase;
    private final GetAllProductsUseCase _getAllProductsUseCase;
    private final DeleteProductUseCase _deleteProductUseCase;
    private final UpdateProductUseCase _updateProductUseCase;
    private final GetOneProductUseCase _getOneProductUseCase;
    public ProductController(
            final CreateProductUseCase createProductUseCase,
            final GetAllProductsUseCase getAllProductsUseCase,
            final DeleteProductUseCase deleteProductUseCase,
            final UpdateProductUseCase updateProductUseCase,
            final GetOneProductUseCase getOneProductUseCase
    ) {
        this._createCreateProductUseCase = createProductUseCase;
        this._getAllProductsUseCase = getAllProductsUseCase;
        this._deleteProductUseCase = deleteProductUseCase;
        this._updateProductUseCase = updateProductUseCase;
        this._getOneProductUseCase = getOneProductUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductRequestDTO body) {
        this._createCreateProductUseCase.execute(body.name, body.price);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public List<Product> getProducts() {
        return this._getAllProductsUseCase.execute();
    }

    @GetMapping(value = "/{id}")
    public Product getOneProduct(@PathVariable String id) { return this._getOneProductUseCase.execute(id); }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        this._deleteProductUseCase.execute(id);

        return ResponseEntity.status(204).build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable String id, @RequestBody ProductRequestDTO body) {
        this._updateProductUseCase.execute(id, body.name, body.price);

        return ResponseEntity.status(204).build();
    }
}
