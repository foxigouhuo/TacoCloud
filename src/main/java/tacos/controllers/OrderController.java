package tacos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tacos.data.OrderTacoRepo;
import tacos.pojo.Order;
import tacos.pojo.OrderTaco;
import tacos.pojo.Taco;
import tacos.data.OrderRepo;

import java.util.UUID;

@Controller
@RequestMapping("tacoOrder")
@SessionAttributes( {"taco","order"})
public class OrderController {
    private final OrderRepo orderRepo;
    private final OrderTacoRepo orderTacoRepo;

    @Autowired
    public OrderController(OrderRepo orderRepo, OrderTacoRepo orderTacoRepo){
        this.orderRepo=orderRepo;
        this.orderTacoRepo = orderTacoRepo;
    }

    @ModelAttribute("order")
    public Order order(){
        return new Order();
    }

    @GetMapping
    public String getOrder(){
        return "designOrderTacos";
    }

    @PostMapping
    public String postOrder(@ModelAttribute Order order,@SessionAttribute Taco taco){
        order.setId(UUID.randomUUID().toString());
        orderRepo.save(order);
        orderTacoRepo.save(new OrderTaco(order.getId(),taco.getId()));
//        System.out.println(taco);
//        System.out.println(order);
        return "redirect:orderInfo";
    }
}
