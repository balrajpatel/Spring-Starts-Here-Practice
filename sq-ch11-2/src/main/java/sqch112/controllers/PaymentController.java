package sqch112.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sqch112.client.PaymentProxy;
import sqch112.model.Payment;

@RestController
public class PaymentController {
    private final PaymentProxy paymentProxy;
    public PaymentController(PaymentProxy paymentProxy) {
        this.paymentProxy = paymentProxy;
    }
    @PostMapping("/payment")
    public Payment payment(@RequestBody Payment payment) {
        return paymentProxy.craatePayment(payment);
    }
}
