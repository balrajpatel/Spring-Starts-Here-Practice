package sqch121.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import sqch121.model.Purchase;

import java.util.List;
@Repository
public class PurchaseRepository {
    private final JdbcTemplate jdbc;
    public PurchaseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    public void storePurchase(Purchase purchase) {
        String sql = "INSERT INTO purchase(product, price) values(?,?)";
        jdbc.update(sql, purchase.getProduct(), purchase.getPrice());
    }
    public List<Purchase> findAllPurchases() {
        String sql = "SELECT * FROM purchase";
        RowMapper<Purchase> rowMapper = (r,i)->{
            Purchase rowObject = new Purchase();
            rowObject.setProduct(r.getString("product"));
            rowObject.setId(r.getInt("id"));
            rowObject.setPrice(r.getBigDecimal("price"));
            return rowObject;
        };
        return jdbc.query(sql, rowMapper);
    }
}
