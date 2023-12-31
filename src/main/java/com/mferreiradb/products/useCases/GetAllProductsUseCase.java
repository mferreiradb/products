package com.mferreiradb.products.useCases;

import com.mferreiradb.products.entities.Product;
import com.mferreiradb.products.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProductsUseCase {
    private final ProductsRepository _productsRepository;

    @Autowired
    public GetAllProductsUseCase(final ProductsRepository productsRepository) {
        this._productsRepository = productsRepository;
    }

    public List<Product> execute() {
        return this._productsRepository.getProducts();
    }
}
