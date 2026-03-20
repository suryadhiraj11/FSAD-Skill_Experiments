package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.Product;
import com.klu.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    ProductRepo pr;

    public Product addProduct(Product product) {
        return pr.save(product);
    }

    public List<Product> getAllProducts() {
        return pr.findAll();
    }

    public Product getProductById(Long id) {
        return pr.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, Product product) {
        Product existing = pr.findById(id).orElse(null);

        if (existing != null) {

            if (product.getName() != null)
                existing.setName(product.getName());

            if (product.getPrice() != null)
                existing.setPrice(product.getPrice());

            if (product.getQuantity() != null)
                existing.setQuantity(product.getQuantity());

            if (product.getImageUrl() != null)
                existing.setImageUrl(product.getImageUrl());

            return pr.save(existing);
        }

        return null;
    }

    public void deleteProduct(Long id) {
        pr.deleteById(id);
    }
}
