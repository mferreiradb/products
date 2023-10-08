package com.example.mferreiradb.products.useCases;

import com.example.mferreiradb.products.entities.Product;
import com.example.mferreiradb.products.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UpdateProductUseCase {
    private final ProductsRepository _productsRepository;

    @Autowired
    public UpdateProductUseCase(final ProductsRepository _productsRepository) {
        this._productsRepository = _productsRepository;
    }

    public void execute(String id, String name, Double price) {
        Optional<Product> productToUpdate = this._productsRepository.getById(id);

        if (productToUpdate.isPresent()) {
            Product product = productToUpdate.get(); // Obtém o objeto Product do Optional

            List<Product> products = this._productsRepository.getProducts();

            int index = products.indexOf(product);

            if (index != -1) {
                this._productsRepository.update(index, name, price); // Remove o produto da lista
            } else {
                System.out.println("Produto não encontrado na lista.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}
