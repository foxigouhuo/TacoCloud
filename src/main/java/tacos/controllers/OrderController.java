package tacos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tacos.data.service.OrderService;
import tacos.data.service.Order_TacoService;
import tacos.pojo.entity.Order;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@RequestMapping("tacoOrder")
public class OrderController {
    private final HttpSession httpSession;
    private final OrderService orderService;
    private final Order_TacoService order_tacoService;

    @Autowired
    public OrderController(HttpSession httpSession, OrderService orderService, Order_TacoService order_tacoService){
        this.httpSession=httpSession;
        this.orderService = orderService;
        this.order_tacoService = order_tacoService;
    }

    @GetMapping
    public String getOrder(Model model){
        Order order = (Order) httpSession.getAttribute("order");
        model.addAttribute(order);
        System.out.println(order);
        return "designOrderTacos";
    }

    @PostMapping
    public String postOrder(@SessionAttribute Order order) {
        saveOrder(order);
        return "showOrderInfo";
    }

    public void saveOrder(Order order){
        order.setId(UUID.randomUUID().toString());
        order.setName("暂时");
        order_tacoService.saveOrder(order);
        orderService.saveOrder(order);
    }
}
