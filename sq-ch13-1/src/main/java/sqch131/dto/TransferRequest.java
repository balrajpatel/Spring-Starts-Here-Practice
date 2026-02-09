package sqch131.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class TransferRequest {
    private int senderAccountId;
    private int receiverAccountId;
    private BigDecimal amount;

}
