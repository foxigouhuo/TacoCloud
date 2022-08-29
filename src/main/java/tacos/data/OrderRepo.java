package tacos.data;

import tacos.Order;

public interface OrderRepo {
    boolean save(Order order);
}
