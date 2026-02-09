package sqch131.model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Account {
    private int id;
    private BigDecimal amount;
    private String name;
}
