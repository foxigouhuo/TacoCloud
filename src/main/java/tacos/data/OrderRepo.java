package tacos.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tacos.Order;

@Repository
public interface OrderRepo extends CrudRepository<Order,Long> {

}
