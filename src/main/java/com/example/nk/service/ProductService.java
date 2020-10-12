package com.example.nk.service;

import com.example.nk.entities.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {
  ResponseEntity<Product> addProduct(Product product);
  ResponseEntity<Product> editProduct(Product product);
  ResponseEntity<Product> deleteProduct(Long id);
}
