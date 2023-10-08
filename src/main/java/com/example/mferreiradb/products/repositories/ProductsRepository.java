package com.example.mferreiradb.products.repositories;

import com.example.mferreiradb.products.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class ProductsRepository {
    private final List<Product> _products;

    public ProductsRepository() {
        this._products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return _products;
    }

    public void create(Product product) {
        this._products.add(product);
    }

    public Optional<Product> getById(String id) { return this._products.stream().filter(product -> product.get_id().equals(id)).findFirst(); }

    public void delete(int index) { this._products.remove(index); }
}
