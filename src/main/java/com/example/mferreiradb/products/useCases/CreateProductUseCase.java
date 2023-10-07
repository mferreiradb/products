package com.example.mferreiradb.products.useCases;

import com.example.mferreiradb.products.entities.Product;
import com.example.mferreiradb.products.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CreateProductUseCase {
    private final ProductsRepository _productsRepository;
    @Autowired
    public CreateProductUseCase(final ProductsRepository productsRepository) {
        this._productsRepository = productsRepository;
    }

    public void execute(String name, Double price) {
        String id = UUID.randomUUID().toString();
        Product product = new Product(id, name, price);
        this._productsRepository.create(product);
    };
}
