package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.Order;

public interface OrderRepo extends CrudRepository<Order,Long> {

}
