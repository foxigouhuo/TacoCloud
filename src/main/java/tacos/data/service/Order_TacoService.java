package tacos.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tacos.data.mapper.Order_TacoMapper;
import tacos.pojo.entity.Order;

@Service
public class Order_TacoService {
    private final Order_TacoMapper order_tacoMapper;

    @Autowired
    public Order_TacoService(Order_TacoMapper order_tacoMapper) {
        this.order_tacoMapper = order_tacoMapper;
    }

    public void saveOrder(Order order){
        order_tacoMapper.saveOrder(order);
    }


}
