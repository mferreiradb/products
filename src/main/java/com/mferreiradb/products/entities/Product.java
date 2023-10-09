package com.mferreiradb.products.entities;
public class Product {
    private final String _id;
    private String _name;
    private Double _price;

    public Product(String _id, String _name, Double _price) {
        this._id = _id;
        this._name = _name;
        this._price = _price;
    }

    public String get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public Double get_price() {
        return _price;
    }

    public void set_price(Double _price) {
        this._price = _price;
    }

    @Override
    public String toString() {
        return "Product {id: " + this._id + ", name: " + this._name + ", price: " + this._price + "}";
    }
}
