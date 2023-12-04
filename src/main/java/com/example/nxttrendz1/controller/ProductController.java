package com.example.nxttrendz1.controller;

import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.service.ProductJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class ProductController {
  @Autowired
  private ProductJpaService productService;

  @GetMapping("/products")
  public ArrayList<Product> getProducts() {
    return productService.getProducts();
  }

  @GetMapping("/products/{productId}")
  public Product getProductById(@PathVariable("productId") int productId) {
    return productService.getProductById(productId);

  }

  @PutMapping("/products/{productId}")
  public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
    return productService.updateProduct(productId, product);
  }

  @PostMapping("/products")
  public Product addProduct(@RequestBody Product product) {
    return productService.addProduct(product);
  }

  @DeleteMapping("/products/{productId}")
  public void deleteProduct(@PathVariable("productId") int productId) {
    productService.deleteProduct(productId);
  }
}

// Write your code here