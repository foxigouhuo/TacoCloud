package tacos.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tacos.data.mapper.OrderMapper;
import tacos.pojo.entity.Order;

import java.util.UUID;

@Service
public class OrderService {

    private final OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }


    public Order getOrder(String name){
        return new Order(UUID.randomUUID().toString(),name,null);
    }

    public void saveOrder(Order order){
        orderMapper.saveOrder(order);
    }
}
