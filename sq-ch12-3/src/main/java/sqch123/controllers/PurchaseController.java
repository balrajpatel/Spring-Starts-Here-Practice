package sqch123.controllers;

import org.springframework.web.bind.annotation.*;
import sqch123.model.Purchase;
import sqch123.repositories.PurchaseRepository;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    private final PurchaseRepository purchaseRepository;
    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }
    @PostMapping
    public void createPurchase(@RequestBody Purchase purchase) {
        purchaseRepository.storePurchase(purchase);
    }
    @GetMapping
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAllPurchases();
    }
}
