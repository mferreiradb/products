package com.example.mferreiradb.products.repositories;

import com.example.mferreiradb.products.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
}
