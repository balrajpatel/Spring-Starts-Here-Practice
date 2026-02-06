package org.example.sqch107.controllers;

import org.example.sqch107.model.PaymentDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentController {
    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment(@RequestBody PaymentDetails paymentDetails) {
        Logger logger = Logger.getLogger(PaymentController.class.getName());
        logger.info("Amount Received: " + paymentDetails.getAmount());
        return
                ResponseEntity
                        .status(HttpStatus.ACCEPTED)
                        .body(paymentDetails);
    }
}
