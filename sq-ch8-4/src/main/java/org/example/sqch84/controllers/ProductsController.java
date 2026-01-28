package org.example.sqch84.controllers;

import org.example.sqch84.model.Product;
import org.example.sqch84.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {
    private final ProductService productService;
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }
    @RequestMapping("/products")
    public String products(Model model) {
        var  products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }
    @RequestMapping(path ="/products", method= RequestMethod.POST)
    public String addProduct(@RequestParam String name,@RequestParam double price, Model model){
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        productService.addProduct(product);
        var  products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    // by default @RequestMapping uses HTTP post method
    // @RequestMapping with HTTP post method is same as @PostMapping
    //in the @...Mapping the HTTP method is specified in the name itself , we just have to mention the path.
    // in @RequestMapping , we specify the path as well the HTTP request method

    // @RequestMapping(path ="/products", method= RequestMethod.POST)  same as
    // @PostMapping("/products")
}
