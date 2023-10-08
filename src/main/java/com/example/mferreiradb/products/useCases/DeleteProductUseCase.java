package com.example.mferreiradb.products.useCases;

import com.example.mferreiradb.products.entities.Product;
import com.example.mferreiradb.products.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeleteProductUseCase {

    private final ProductsRepository _productsRepository;

    @Autowired
    public DeleteProductUseCase(final ProductsRepository productsRepository) {
        this._productsRepository = productsRepository;
    }

    public void execute(String id) {

        Optional<Product> productToRemove = this._productsRepository.getById(id);

        if (productToRemove.isPresent()) {
            Product product = productToRemove.get(); // Obtém o objeto Product do Optional

            List<Product> products = this._productsRepository.getProducts();

            int index = products.indexOf(product);

            if (index != -1) {
                this._productsRepository.delete(index); // Remove o produto da lista
            } else {
                System.out.println("Produto não encontrado na lista.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}
