package sqch104.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sqch104.exceptions.NotEnoughMoneyException;
import sqch104.model.ErrorDetails;
import sqch104.model.PaymentDetails;
import sqch104.services.PaymentService;

@RestController
public class PaymentController {
    private PaymentService paymentService;
    PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/payment")
    public ResponseEntity<?> makePayment(){
        try{
            PaymentDetails paymentDetails = paymentService.processPayment();
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);

            }catch(NotEnoughMoneyException e)

            {
                ErrorDetails errorDetails = new ErrorDetails();
                errorDetails.setMessage("Not enough money");
                return ResponseEntity
                        .badRequest()
                        .body(errorDetails);
            }

    }


}
