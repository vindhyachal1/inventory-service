package com.vindhyachal.inventory_service.service;

import com.vindhyachal.inventory_service.entity.Product;
import com.vindhyachal.inventory_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCateogy(String category) {
        return productRepository.findByCategory(category);
    }

    //Update stock
    public Product updateStock(int id, int stock) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    existingProduct.setStock(stock);
    return productRepository.save(existingProduct);
    }

    //receive new shipment
    public Product receiveNewShipment(int id, int quantity) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        existingProduct.setStock(existingProduct.getStock()+quantity);
        return productRepository.save(existingProduct);
    }
}
