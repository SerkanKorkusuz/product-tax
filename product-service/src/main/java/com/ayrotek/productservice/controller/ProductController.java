package com.ayrotek.productservice.controller;

import com.ayrotek.productservice.model.Product;
import com.ayrotek.productservice.repository.UserRepository;
import com.ayrotek.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public List<Product> list() {
        return productService.listAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Integer id) {
        try {
            Product product = productService.getProduct(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Product product, @RequestHeader("AuthToken") String token) {
        int userId = userRepository.findByToken(token).get(0).getId();
        product.setUserId(userId);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String create_date = formatter.format(date);
        product.setCreateDate(create_date);
        product.setUpdateDate(create_date);
        productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Product product, @RequestHeader("AuthToken") String token,
                                    @PathVariable Integer id) {
        try {
            Product existingProduct = productService.getProduct(id);
            int productUserId = existingProduct.getUserId();
            int userId = userRepository.findByToken(token).get(0).getId();
            if (productUserId == userId) {
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String update_date = formatter.format(date);
                product.setUpdateDate(update_date);
                productService.saveProduct(product);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@RequestHeader("AuthToken") String token, @PathVariable Integer id) {
        try {
            Product existingProduct = productService.getProduct(id);
            int productUserId = existingProduct.getUserId();
            int userId = userRepository.findByToken(token).get(0).getId();
            if (productUserId == userId) {
                productService.deleteProduct(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}