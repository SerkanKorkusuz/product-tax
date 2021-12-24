package com.ayrotek.productservice.controller;

import com.ayrotek.productservice.service.ProductService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("products", productService.listAllProducts());

        return "index"; //view
    }

}