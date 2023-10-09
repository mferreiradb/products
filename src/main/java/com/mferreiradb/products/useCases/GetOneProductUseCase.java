package com.mferreiradb.products.useCases;

import com.mferreiradb.products.entities.Product;
import com.mferreiradb.products.repositories.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetOneProductUseCase {
    private final ProductsRepository _productsRepository;

    public GetOneProductUseCase(ProductsRepository _productsRepository) {
        this._productsRepository = _productsRepository;
    }

    public Product execute(String id) {
        Optional<Product> product = this._productsRepository.getById(id);

            Product productToReturn = product.get(); // Obtém o objeto Product do Optional
            return productToReturn;
    }
}
