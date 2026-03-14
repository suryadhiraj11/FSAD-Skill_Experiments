package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.model.Product;
import com.klu.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {
  @Autowired
  ProductService ps;
  
    // CREATE Product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return ps.addProduct(product);
    }

    // READ All Products
    @GetMapping
    public List<Product> getAllProducts() {
        return ps.getAllProducts();
    }

    // READ Product By ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return ps.getProductById(id);
    }

    // UPDATE Product
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @RequestBody Product product) {
        return ps.updateProduct(id, product);
    }

    // DELETE Product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        ps.deleteProduct(id);
        return "Product deleted successfully";
    }
    
}