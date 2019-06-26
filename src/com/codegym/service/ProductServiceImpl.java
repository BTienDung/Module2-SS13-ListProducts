package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Mac", 1000, "Máy tính", "Apple", "a"));
        products.put(2, new Product(2, "Samsung Gear s3", 500, "Đồng hồ", "Samsung","a"));
        products.put(3, new Product(3, "Apple Watch", 700, "Đồng hồ", "Apple","a"));
        products.put(4, new Product(4, "Hitachi", 1200, "Tủ lạnh", "Hitachi","a"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findByName(String name) {
        List<Product> list = new ArrayList<>(products.values());
        for (Product product: list){
            if (product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
    @Override
    public Product findById(int id){
       return products.get(id);
    }
}
