package org.example.sqch85.controllers;

import org.example.sqch85.model.Product;
import org.example.sqch85.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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
    @PostMapping(path ="/products")
    public String addProduct(Product p, Model model){
        productService.addProduct(p);
        var  products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }

/*
        What changed?

        ➡️ Spring changed the binding strategy, not the URL or HTTP method.

        3️⃣ How Spring binds Product p automatically 🤯
        Request:
        POST /products
        name=Laptop&price=50000

        Spring sees:
        Product p

        Spring internally:
        Creates new Product() (default constructor)
        Looks at request parameter names
        Matches them with setter names

        Request param	Setter called
        name	setName()
        price	setPrice()

        Equivalent to:
        Product p = new Product();
        p.setName(request.getParameter("name"));
        p.setPrice(Double.parseDouble(request.getParameter("price")));

        🔥 Spring writes this code for you

        4️⃣ Why did parameters "change"?

        They didn’t really change — Spring just grouped them into an object.

        Think of it like:
        // Instead of this
        addProduct(String name, double price)

        // Spring gives you this
        addProduct(Product p)

        This is called a:
        Command Object / Form Backing Object



        Important rule (this must be true)
        For auto-binding to work:
        HTML name attributes must match field names
        POJO must have setters
        Default constructor must exist  (if creating a other ctor, then just define a no-arg simple ctor
        which spring can use to create object and then use getter , setter method.
 */
}
