package com.example.mferreiradb.products.repositories;

import com.example.mferreiradb.products.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class ProductsRepository {
    private List<Product> _products;

    public ProductsRepository() {
        this._products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return _products;
    }

    public void create(Product product) {
        this._products.add(product);
    }

    private Optional<Product> getById(String id) {
        return this._products.stream().filter(product -> product.get_id().equals(id)).findFirst();
    }

    public void deleteById(String id) {
        Optional<Product> productToRemove = this.getById(id);

        if (productToRemove.isPresent()) {
            Product product = productToRemove.get(); // Obtém o objeto Product do Optional
            int index = this._products.indexOf(product);

            if (index != -1) {
                this._products.remove(index); // Remove o produto da lista
            } else {
                System.out.println("Produto não encontrado na lista.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}
