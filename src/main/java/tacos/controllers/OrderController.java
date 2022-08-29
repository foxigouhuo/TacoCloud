package tacos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tacos.Order;
import tacos.Taco;
import tacos.data.OrderRepoImpl;

@Controller
@RequestMapping("tacoOrder")
@SessionAttributes({"order", "taco"})
public class OrderController {
    private OrderRepoImpl orderRepo;

    @ModelAttribute("order")
    public Order order(){
        return new Order();
    }

    @Autowired
    public OrderController(OrderRepoImpl orderRepo){
        this.orderRepo=orderRepo;
    }

    @GetMapping
    public String getOrder(Model model){
        return "designOrderTacos";
    }

    @PostMapping
    public String postOrder(Order order,Taco taco){
//        System.out.println("order："+order);
//        System.out.println("taco："+taco);
        order.addTaco(taco.getId());
        orderRepo.save(order);
        return "redirect:orderInfo";
    }
}
