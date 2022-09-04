package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.pojo.OrderTaco;

import java.util.List;

public interface OrderTacoRepo extends CrudRepository<OrderTaco,String> {

    List<OrderTaco> findOrderTacoByOrderId(String id);
}
