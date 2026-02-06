package sqch105.services;

import org.springframework.stereotype.Service;
import sqch105.exceptions.NotEnoughMoneyException;
import sqch105.model.PaymentDetails;

@Service
public class PaymentService {
    public PaymentDetails processPayment(){
        throw new NotEnoughMoneyException();
    }
}
