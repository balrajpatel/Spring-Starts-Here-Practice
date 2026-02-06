package sqch105.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sqch105.exceptions.NotEnoughMoneyException;
import sqch105.model.ErrorDetails;
import sqch105.model.PaymentDetails;
import sqch105.services.PaymentService;

@RestController
public class PaymentController {
    private final PaymentService paymentService;
    PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/payment")
    public ResponseEntity<?> makePayment(){

            PaymentDetails paymentDetails = paymentService.processPayment();
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);

    }


}
