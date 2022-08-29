package tacos.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import tacos.Order;

import java.sql.Types;
import java.util.Arrays;

@Repository
public class OrderRepoImpl implements OrderRepo{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderRepoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public boolean save(Order order) {

//        PreparedStatementCreator psc=new PreparedStatementCreatorFactory(
//                "insert into tacoorder (consignee,deliveryAddress,remarks)" +
//                        "values (?,?,?)",
//                Types.VARCHAR,
//                Types.VARCHAR,
//                Types.VARCHAR
//        ).newPreparedStatementCreator(
//                Arrays.asList(
//                        order.getConsignee(),
//                        order.getDeliveryAddress(),
//                        order.getRemarks()
//                )
//        );
        jdbcTemplate.update(
                "insert into tacoorder (consignee,deliveryAddress,remarks) " +
                        "values (?,?,?)",
                order.getConsignee(),
                order.getDeliveryAddress(),
                order.getRemarks()
        );

        Integer tacoId=jdbcTemplate.queryForObject(
                "select id from tacoorder where consignee = ?",
                (rs,rowNum)->rs.getInt("id"),
                order.getConsignee()
        );
        order.getTacoIds().forEach(x -> saveOrderTaco(tacoId,x));
        return true;
    }

    private boolean saveOrderTaco(int orderId,int tacoId){
        jdbcTemplate.update(
                "insert into tacoorder_taco (orderId,tacoId) values (?,?)",
                orderId,
                tacoId
        );
        return true;
    }
}
