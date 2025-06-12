package com.example.demo.controllers;


import com.example.demo.domain.InhousePart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller

public class BuyProduct {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam long productID){
        Optional<Product> product = productRepository.findById(productID);
        if(product.isPresent()) {
            Product validProduct = product.get();
            if(validProduct.getInv() > 0) {
                validProduct.setInv(validProduct.getInv() - 1);
                productRepository.save(validProduct);
                return "successPurchase";
            }
        }
        return "failurePurchase";
    }

}