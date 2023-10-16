package com.mferreiradb.products.useCases;

import com.mferreiradb.products.entities.Product;
import com.mferreiradb.products.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

@Service
public class CreateProductUseCase {
    private final ProductsRepository _productsRepository;
    @Autowired
    public CreateProductUseCase(final ProductsRepository productsRepository) {
        this._productsRepository = productsRepository;
    }

    public void execute(String name, Double price) {

        if(name.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Name cant be empty");
        }

        String id = UUID.randomUUID().toString();
        Product product = new Product(id, name, price);
        this._productsRepository.create(product);
    }
}
