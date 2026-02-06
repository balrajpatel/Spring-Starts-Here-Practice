package sqch104.services;

import org.springframework.stereotype.Service;
import sqch104.exceptions.NotEnoughMoneyException;
import sqch104.model.PaymentDetails;
@Service
public class PaymentService {
    public PaymentDetails processPayment(){
        throw new NotEnoughMoneyException();
    }
}
