package com.product.productManage.service;

import com.product.productManage.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductService {
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "iPhone", 1000, "Apple smartphone", "Electronics", "Apple", 50, 0.174, 10),
            new Product(102, "Tablet", 2000, "Android tablet", "Electronics", "Samsung", 100, 0.300, 15),
            new Product(103, "Laptop", 1500, "Gaming laptop", "Electronics", "Dell", 30, 2.5, 5),
            new Product(104, "Smartwatch", 500, "Smart wearable device", "Wearables", "Fitbit", 200, 0.05, 20),
            new Product(105, "Camera", 1200, "DSLR camera", "Electronics", "Canon", 40, 1.0, 12),
            new Product(106, "Headphones", 150, "Noise-cancelling headphones", "Accessories", "Bose", 500, 0.2, 8),
            new Product(107, "Monitor", 300, "27-inch display", "Peripherals", "LG", 70, 5.0, 7),
            new Product(108, "Keyboard", 50, "Mechanical keyboard", "Peripherals", "Logitech", 250, 0.8, 18),
            new Product(109, "Mouse", 30, "Wireless mouse", "Peripherals", "Logitech", 300, 0.1, 20),
            new Product(110, "Speakers", 100, "Bluetooth speakers", "Audio", "Sony", 150, 1.5, 10)
    ));

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int prodId) {
        return products.stream()
                .filter(product -> product.getId() == prodId)
                .findFirst().orElse(new Product(100, "nothing", 0, "nothing", "nothing", "nothing", 0, 0, 0));
    }

    public Product AddProduct(Product product) {
        products.add(product);
        return product;
    }

    public Product updateProduct(int prodId, Product product) {
        Product oldproduct = null;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == prodId) {
                products.set(i, product);
                oldproduct = products.get(i);
            }
        }
        return oldproduct;
    }

    public Product deleteProduct(int prodId) {
        Product oldproduct = null;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == prodId) {
                products.remove(i);
            }
        }
        return oldproduct;
    }
}
