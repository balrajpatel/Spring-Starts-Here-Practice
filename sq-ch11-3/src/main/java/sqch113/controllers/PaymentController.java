package sqch113.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import sqch113.client.PaymentsProxy;
import sqch113.model.Payment;

import java.util.UUID;

@RestController
public class PaymentController {
    private PaymentsProxy paymentsProxy;
    public PaymentController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }
    @PostMapping("/payment")
    public Mono<Payment> payment(@RequestBody Payment payment) {
        String requestId = UUID.randomUUID().toString();
        return paymentsProxy.getPayment(requestId, payment);
    }
}
