package com.product.productManage.controllers;

import com.product.productManage.model.Product;
import com.product.productManage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    ProductService service = new ProductService();

    @RequestMapping("/")
    public String home() {
        return "Welcome to Product Manage";
    }

    @RequestMapping("/about")
    public String about() {
        return "Welcome to Product Manage";
    }

    @RequestMapping("/products")
    public List<Product> getProducts() {
        System.out.println("Hello my app");
        return service.getProducts();
    }

    @RequestMapping("/products/{prodId}")
    public Product getPriductById(@PathVariable int prodId) {
        return service.getProductById(prodId);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return service.AddProduct(product);
    }

    @PutMapping("/products/{prodId}")
    public Product updateProduct(@PathVariable int prodId, @RequestBody Product product) {
        return service.updateProduct(prodId, product);
    }

    @DeleteMapping("/products/{prodId}")
    public String deleteProduct(@PathVariable int prodId) {
        service.deleteProduct(prodId);
        return "Product Deleted successfully";
    }
}
