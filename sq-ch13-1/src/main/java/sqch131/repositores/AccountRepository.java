package sqch131.repositores;


import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;
import sqch131.mapper.AccountRowMapper;
import sqch131.model.Account;

import java.math.BigDecimal;

import java.util.List;

@Repository
public class AccountRepository {

    private final JdbcTemplate jdbcTemplate;
    public AccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Account findAmountById(int id) {
        String sql = "select * from account where id = ?";
        return jdbcTemplate.queryForObject(sql, new AccountRowMapper(), id);
    }

    public void changeAmount(int id, BigDecimal amount) {
        String sql = "update account set amount = ? where id = ?";
        jdbcTemplate.update(sql, amount, id);
    }

    public List<Account> findAllAccounts() {
        String sql = "select * from account";
        return jdbcTemplate.query(sql, new AccountRowMapper());
    }

}
