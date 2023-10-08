package com.example.mferreiradb.products.useCases;

import com.example.mferreiradb.products.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductUseCase {

    private final ProductsRepository _productsRepository;

    @Autowired
    public DeleteProductUseCase(final ProductsRepository productsRepository) {
        this._productsRepository = productsRepository;
    }

    public void execute(String id) {
        this._productsRepository.deleteById(id);
    }
}
