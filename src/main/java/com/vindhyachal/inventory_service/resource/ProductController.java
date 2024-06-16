package com.vindhyachal.inventory_service.resource;

import com.vindhyachal.inventory_service.entity.Product;
import com.vindhyachal.inventory_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//@RequestMapping("/products")
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

//    @GetMapping
    @QueryMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

//    @GetMapping("/{category}")
    @QueryMapping
    public List<Product> getProductsByCateogy(@Argument String category) {
        return productService.getProductsByCateogy(category);
    }

    @MutationMapping
    public Product updateStock(@Argument int id, @Argument int stock) {
        return productService.updateStock(id, stock);
    }

    @MutationMapping
    public Product receiveNewShipment(@Argument int id, @Argument int quantity) {
        return productService.receiveNewShipment(id, quantity);
    }
}
