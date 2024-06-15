package com.vindhyachal.inventory_service.resource;

import com.vindhyachal.inventory_service.entity.Product;
import com.vindhyachal.inventory_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{category}")
    public List<Product> getProductsByCateogy(@PathVariable String category) {
        return productService.getProductsByCateogy(category);
    }
}
