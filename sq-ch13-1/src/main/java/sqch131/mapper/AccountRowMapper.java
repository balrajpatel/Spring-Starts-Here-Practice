package sqch131.mapper;

import org.springframework.jdbc.core.RowMapper;
import sqch131.model.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    public Account mapRow(ResultSet r, int i) throws SQLException {
        Account account = new Account();
        account.setId(r.getInt("id"));
        account.setAmount(r.getBigDecimal("amount"));
        account.setName(r.getString("name"));
        return account;
    }
}
