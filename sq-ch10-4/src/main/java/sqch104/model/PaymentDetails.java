package sqch104.model;

import org.springframework.stereotype.Service;

public class PaymentDetails {
    private double  amount;
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public double getAmount() {
        return amount;
    }
}
